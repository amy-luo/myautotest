package com.mytest.ptbase.base;

import com.mytest.ptbase.Utils.MyDataProvider;
import com.mytest.ptbase.Utils.TestData;
import com.mytest.ptbase.Utils.TestDataRepository;
import com.mytest.ptbase.Utils.TestLogicRepository;
import com.mytest.ptbase.api.base.CCPrepare;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.lf5.util.Resource;
import org.apache.log4j.lf5.util.ResourceUtils;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

public class SpecificCaseStarter {
    org.slf4j.Logger logger= LoggerFactory.getLogger(SpecificCaseStarter.class);

   static String fileName = "testcase/listCase.yaml";
   final static String basePackage = "com.mytest.ptbase.api";
    @BeforeClass
    public void init(){
        initLog();
    }

    public void initLog(){
        URL url = ResourceUtils.getResourceAsURL(this,new Resource("log4j.properties"));
        System.out.println(url.getPath());
        PropertyConfigurator.configure(url.getPath());
    }

    @DataProvider(name = "myDataProvider")
    public Iterator<Object[]> batchDataProvider(Method method) {
        return new MyDataProvider(loadTestData(loadTestCase()));
    }

    @DataProvider(name = "myDataProvider_all")
    public Iterator<Object[]> batchDataProvider_all(Method method) {
        return new MyDataProvider(loadTestData(loadTestCase()));
    }


    @Test(dataProvider = "myDataProvider")
    public void test(TestData testData) {
        TestLogicRepository testLogicRepository = new TestLogicRepository();
        List<String> ccils = testLogicRepository.loadTestLogic(testData);
        HashMap<String, Object> paramMap = new HashMap<>(testData.getDataItems());
        for (int i=0;i<ccils.size();i++) {
            String api = ccils.get(i);
            try {
                Reflections f = new Reflections(new ConfigurationBuilder().setUrls(ClasspathHelper.forPackage(basePackage)).setScanners(new MethodAnnotationsScanner()));
                Set<Method> methods = f.getMethodsAnnotatedWith(CCPrepare.class);
                for (Method method : methods) {
                    CCPrepare ccPrepare = method.getAnnotation(CCPrepare.class);
                    if (ccPrepare.id().equalsIgnoreCase(api)) {
//                      Object object = method.getDeclaringClass().newInstance();
                        try {logger.info("开始执行! api= "+api);
                            Class clazz = method.getDeclaringClass();
                            paramMap = (HashMap<String, Object>) method.invoke(clazz,paramMap);
                            logger.info("执行成功! api= "+api);
                            break;
                        } catch (InvocationTargetException e) {
                                e.printStackTrace();
                                Assert.assertTrue(false);
                            }
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    Assert.assertTrue(false);
                }
//                } catch (InstantiationException e) {
//                    e.printStackTrace();
//                    Assert.assertTrue(false);
//                }
            }
        }
//    public void test(TestData testData) {
//        TestLogicRepository testLogicRepository = new TestLogicRepository();
//        HashMap<ArrayList<String>, HashMap<String, List<HashMap<String, String>>>> map = testLogicRepository.loadTestLogic(testData);
//        Set<ArrayList<String>> key = map.keySet();
//        HashMap<String, Object> paramMap = new HashMap<>(testData.getDataItems());
//        for (ArrayList<String> k : key) {
//            List apiList = k;
//            HashMap<String, List<HashMap<String, String>>> map2 = map.get(k);
//            for (int i = 0; i < k.size(); i++) {
//                String api = k.get(i);
//                List<HashMap<String, String>> totalList = map2.get(api);
//                HashMap<String, String> preApiMap = totalList.get(0);
//                HashMap<String, String> dataMap = totalList.get(1);
//                String returnParamMap = preApiMap.get("returnParamMap");
//                String annotation = preApiMap.get("annotation");
//                ArrayList<Object> dataList=new ArrayList<>();
//                for (String methodParam : dataMap.keySet()) {
//                    String dataParam = dataMap.get(methodParam);
//                    Object dataParam1 = testData.getDataItem(dataParam);
//                    paramMap.put(methodParam, dataParam1);
//                }
//                    try {
//                        Reflections f = new Reflections(new ConfigurationBuilder().setUrls(ClasspathHelper.forPackage(basePackage)).setScanners(new MethodAnnotationsScanner()));
//                        Set<Method> methods = f.getMethodsAnnotatedWith(CCPrepare.class);
//                        for (Method method : methods) {
//                            CCPrepare ccPrepare = method.getAnnotation(CCPrepare.class);
//                            if (ccPrepare.id().equalsIgnoreCase(api)) {
//                                try {
////                                Object object = method.getDeclaringClass().newInstance();
//                                    logger.info("开始执行! api= "+api);
//                                    Class clazz = method.getDeclaringClass();
//                                    paramMap = (HashMap<String, Object>) method.invoke(clazz,paramMap);
//                                    logger.info("执行成功! api= "+api);
//                                    break;
//                                } catch (InvocationTargetException e) {
//                                    e.printStackTrace();
//                                    Assert.assertTrue(false);
//                                }
//                            }
//                        }
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                        Assert.assertTrue(false);
//                    }
////                } catch (InstantiationException e) {
////                    e.printStackTrace();
////                    Assert.assertTrue(false);
////                }
//                }
//            }
//        }

    //加载listCase.yaml中的testcases，存入添加进List<String>
    public List<String> loadTestCase(){
        Yaml yaml = new Yaml();
        InputStream stream = ResourceUtils.getResourceAsStream(this,new Resource(fileName));
        Set<String>  testDatas = new HashSet<String>();
        try {
            String o = yaml.loadAs(stream,String.class);
            if (null == o){
                return null;
            }
            String []data = o.split(" ");
            for (int i = 0;i<data.length;i++){
                testDatas.add(data[i]);
            }
        }catch (Exception e){
        e.printStackTrace();
        }
        return new ArrayList<String >(testDatas);
    }

    //将获取刚刚加载testcase里面的testData数据模型，添加进List<TestData>
    public List<TestData> loadTestData(List<String> testCase){
        TestDataRepository testDataRepository = new TestDataRepository();
        return testDataRepository.getCaseData(testCase);
    }

    public List<TestData> loadTestData(){
        TestDataRepository testDataRepository = new TestDataRepository();
        return testDataRepository.getCaseData();
    }
}

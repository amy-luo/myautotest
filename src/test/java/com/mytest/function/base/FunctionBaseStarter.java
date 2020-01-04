package com.mytest.function.base;

import com.mytest.function.api.base.CCPrepare;
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

public class FunctionBaseStarter {
    org.slf4j.Logger logger= LoggerFactory.getLogger(FunctionBaseStarter.class);

   static String fileName = "testcase/listCase.yaml";
   final static String basePackage = "com.mytest.function.api";
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


    @Test(dataProvider = "myDataProvider")
    public void test(TestData testData) {
        TestLogicRepository testLogicRepository = new TestLogicRepository();
        HashMap<ArrayList<String>, HashMap<String, List<HashMap<String,String>>>> map = testLogicRepository.loadTestLogic(testData);
        Set<ArrayList<String>> key = map.keySet();
        HashMap<String, Object> paramMap = new HashMap<>(testData.getDataItems());
        for (ArrayList<String> k : key) {
            List apiList = k;
            HashMap<String, List<HashMap<String,String>>> map2 = map.get(k);
            for (int i = 0; i < k.size(); i++) {
                String api = k.get(i);
                List<HashMap<String, String>> totalList = map2.get(api);
                HashMap<String,String> preApiMap=totalList.get(0);
                HashMap<String,String> dataMap=totalList.get(1);
                String returnParamMap=preApiMap.get("returnParamMap");
                String annotation=preApiMap.get("annotation");
                for (String methodParam : dataMap.keySet()) {
                    String dataParam = dataMap.get(methodParam);
                    Object dataParam1 = testData.getDataItem(dataParam);
                    paramMap.put(methodParam, dataParam1);
                }
                try {
                    Reflections f = new Reflections(new ConfigurationBuilder().setUrls(ClasspathHelper.forPackage(basePackage)).setScanners(new MethodAnnotationsScanner()));
                    Set<Method> methods = f.getMethodsAnnotatedWith(CCPrepare.class);
                    for (Method method : methods) {
                        CCPrepare ccPrepare = method.getAnnotation(CCPrepare.class);
                        if (ccPrepare.id().equalsIgnoreCase(api)) {
                            try {
//                                Object object = method.getDeclaringClass().newInstance();
                                logger.info("正在执行"+api);
                                Class c = method.getDeclaringClass();
                                paramMap=(HashMap<String, Object>) method.invoke(c, paramMap);
                                logger.info(api+"执行成功");
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
    }

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
}

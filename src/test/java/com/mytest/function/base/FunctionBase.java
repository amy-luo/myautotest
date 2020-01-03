package com.mytest.function.base;

import com.mytest.function.api.base.CCPrepare;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.lf5.util.Resource;
import org.apache.log4j.lf5.util.ResourceUtils;
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

public class FunctionBase {

   static String fileName = "testcase/listCase.yaml";
   final static String basePackage = "com.mytest.function";
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
        HashMap<ArrayList<String>, HashMap<String, HashMap<String, String>>> map = testLogicRepository.loadTestLogic(testData);
        Set<ArrayList<String>> key = map.keySet();
        for (ArrayList<String> k : key) {
            List apiList = k;
            HashMap<String, HashMap<String, String>> map2 = map.get(k);
            for (int i = 0; i < k.size(); i++) {
                String api = k.get(i);
                HashMap<String, String> dataMap = map2.get(api);
                HashMap<String, Object> paramMap = new HashMap<>();
                for (String methodParam : dataMap.keySet()) {
                    String dataParam = dataMap.get(methodParam);
                    Object dataParam1 = testData.getDataItem(dataParam);
                    paramMap.put(methodParam, dataParam1);
                }
                try {
                    Class c = Class.forName(api);
                    Method[] methods = c.getDeclaredMethods();
                    for (Method method : methods) {
                        CCPrepare ccPrepare = method.getAnnotation(CCPrepare.class);
                        if (ccPrepare.id().equalsIgnoreCase(api)) {
                            try {
                                Object object = method.getDeclaringClass().newInstance();
                                method.invoke(object, paramMap);
                                break;
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                                Assert.assertTrue(false);
                            }
                        }
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
            //利用java反射机制，从用例的相对路径推导出测试逻辑的路径，得到相应testData的logic方法，执行对应的测试逻辑；
//        String logicPackage =basePackage+"."+testData.getLogicPackage();
//        Reflections f = new Reflections(new ConfigurationBuilder().setUrls(ClasspathHelper.forPackage(logicPackage)).setScanners(new MethodAnnotationsScanner()));
//        Set<Method> methods = f.getMethodsAnnotatedWith(TestLogic.class);
//        for(Method method:methods){
//            TestLogic logic = method.getAnnotation(TestLogic.class);
//            if(logic.name().equalsIgnoreCase(testData.getLogicId())){
//                try {
//                    Object object = method.getDeclaringClass().newInstance();
//                    method.invoke(object,testData.getDataItems());
//                    break;
//                }catch (Exception e){
//                    e.printStackTrace();
//                    Assert.assertTrue(false);
//                }
//            }
//        }
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

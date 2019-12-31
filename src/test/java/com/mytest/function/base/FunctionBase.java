package com.mytest.function.base;

import com.mytest.function.testcase.Inface.TestLogic;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.lf5.util.Resource;
import org.apache.log4j.lf5.util.ResourceUtils;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
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

    @BeforeClass
    public void initLog(){
        URL url = ResourceUtils.getResourceAsURL(this,new Resource("log4j.properties"));
        System.out.println(url.getPath());
        PropertyConfigurator.configure(url.getPath());
    }

    @DataProvider(
            name = "myDataProvider"
    )
    public Iterator<Object[]> batchDataProvider(Method method) {
        return new MyDataProvider(loadTestData(loadTestCase()));
    }

    @Test(dataProvider = "myDataProvider")
    public void test(TestData testData){
        String logicPackage =basePackage+"."+testData.getLogicPackage();
        Reflections f = new Reflections(new ConfigurationBuilder().setUrls(ClasspathHelper.forPackage(logicPackage)).setScanners(new MethodAnnotationsScanner()));
        Set<Method> methods = f.getMethodsAnnotatedWith(TestLogic.class);
        for(Method method:methods){
            TestLogic logic = method.getAnnotation(TestLogic.class);
            if(logic.name().equalsIgnoreCase(testData.getLogicId())){
                try {
                    Object object = method.getDeclaringClass().newInstance();
                    method.invoke(object,testData.getDataItems());
                    break;
                }catch (Exception e){
                    e.printStackTrace();
                    Assert.assertTrue(false);
                }
            }
        }
    }

    public List<String> loadTestCase(){
        Yaml yaml = new Yaml();
        InputStream stream = ResourceUtils.getResourceAsStream(new FunctionBase(),new Resource(fileName));
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
    public List<TestData> loadTestData(List<String> testCase){
        TestDataRepository testDataRepository = new TestDataRepository();
        return testDataRepository.getCaseData(testCase);
    }
}

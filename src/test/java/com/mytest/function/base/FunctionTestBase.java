/*
* Copyright (c) 2016 xiaoyouzi.com. All Rights Reserved.
*/
package com.mytest.function.base;

import com.mytest.function.Utils.MyDataProvider;
import com.mytest.function.Utils.TestData;
import com.mytest.function.Utils.TestDataRepository;
import com.mytest.function.Utils.TestLogicRepository;
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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by LIMSHEN
 * Date: 20/1/5
 * Time: 21:48
 */
public class FunctionTestBase {
    org.slf4j.Logger logger= LoggerFactory.getLogger(SpecificCaseStarter.class);
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

    @DataProvider(name = "myDataProvider_all")
    public Iterator<Object[]> batchDataProvider_all(Method method) {
        return new MyDataProvider(loadTestData());
    }


    @Test(dataProvider = "myDataProvider_all")
    public void test(TestData testData) {
        TestLogicRepository testLogicRepository = new TestLogicRepository();
        List<String> ccils = testLogicRepository.loadTestLogic(testData);
        HashMap<String, Object> paramMap = new HashMap<>(testData.getDataItems());
        for (int i = 0; i < ccils.size(); i++) {
            String api = ccils.get(i);
            try {
                Reflections f = new Reflections(new ConfigurationBuilder().setUrls(ClasspathHelper.forPackage(basePackage)).setScanners(new MethodAnnotationsScanner()));
                Set<Method> methods = f.getMethodsAnnotatedWith(CCPrepare.class);
                for (Method method : methods) {
                    CCPrepare ccPrepare = method.getAnnotation(CCPrepare.class);
                    if (ccPrepare.id().equalsIgnoreCase(api)) {
//                      Object object = method.getDeclaringClass().newInstance();
                        try {
                            logger.info("开始执行! api= " + api);
                            Class clazz = method.getDeclaringClass();
                            paramMap = (HashMap<String, Object>) method.invoke(clazz, paramMap);
                            logger.info("执行成功! api= " + api);
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
        }
    }

    public List<TestData> loadTestData(){
        TestDataRepository testDataRepository = new TestDataRepository();
        return testDataRepository.getCaseData();
    }
}

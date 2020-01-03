package com.mytest.function.base;

import org.apache.log4j.lf5.util.Resource;
import org.yaml.snakeyaml.Yaml;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;

/**
 * @author LIMSHEN
 * @date 2020/1/3 21:45
 */
public class TestLogicRepository {
    TestLogic testLogic;
    HashMap<String, HashMap<String, String>> map=new HashMap<>();
    public HashMap<String, HashMap<String, String>> loadTestLogic(TestData testData) {
        File file = new File(new Resource(testData.getLogicPackage().replace(".","/")).getURL().getFile());
        File[] listFiles = file.listFiles();
        Yaml yaml = new Yaml();
        for (File logicYaml : listFiles) {
            try {
                if (logicYaml.getName().contains(".logic.yaml")) {
                    List<TestLogic> loadLogic = (List<TestLogic>)yaml.load(new FileInputStream(logicYaml));
                    String s=loadLogic.toString();
                    for (TestLogic logic:loadLogic) {
                        if (logic.getLogicId().equals(testData.getLogicId())) {
                            testLogic=logic;
                            List<String> ccils =(List<String>) testLogic.getCcils();
                            map = getLogic(ccils);
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(testLogic.getLogicId()!=null&testLogic.getLogicId()!=""){
                break;
            }
        }
        return map;
    }
    //    ccils: |
//    paramMap=ccprepare:CheckRegisteredUserAndSendOTPTest?phoneNumber=${phoneNumber}
    public HashMap<String, HashMap<String,String>> getLogic(List<String> ccils){
        HashMap<String, HashMap<String,String>> map=new HashMap<>();
        for(String ccil: ccils){
            String api=ccil.substring(ccil.indexOf("paramMap=ccprepare:")+1,ccil.indexOf("?"));
            String params = ccil.substring(ccil.indexOf("?") + 1);
            String[] paramSimple = params.split("&");
            HashMap<String,String> dataMap=new HashMap<String,String>();
            for(String param:paramSimple){
                //方法参数名
                String methodParam=param.substring(0,param.indexOf("="));
                //参数值
                String dataParam=param.substring(param.indexOf("{")+1,param.indexOf("}"));
//                TestData testData=new TestData();
                dataMap.put(methodParam,dataParam);
            }
            map.put(api,dataMap);
        }
        return map;
    }
}

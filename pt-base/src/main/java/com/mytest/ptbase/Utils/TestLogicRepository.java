package com.mytest.ptbase.Utils;

import org.apache.log4j.lf5.util.Resource;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 * @author LIMSHEN
 * @date 2020/1/3 21:45
 */
public class TestLogicRepository {
    TestLogic testLogic;
    List<String> ccils;
    public List<String> loadTestLogic(TestData testData) {
        File file = new File(new Resource(testData.getLogicPackage().replace(".","/")).getURL().getFile());
        File[] listFiles = file.listFiles();
        Yaml yaml = new Yaml();
        for (File logicYaml : listFiles) {
            if(testLogic!=null){
                break;}
            try {
                if (logicYaml.getName().contains("logic.yaml")) {
                    List<TestLogic> loadLogic = (List<TestLogic>)yaml.load(new FileInputStream(logicYaml));
                    for (TestLogic logic:loadLogic) {
                        if (logic.getLogicId().equals(testData.getLogicId())) {
                            testLogic=logic;
                            ccils =(List<String>) testLogic.getCcils();
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ccils;
    }
    //    ccils: |
//    paramMap=ccprepare:CheckRegisteredUserAndSendOTPTest?phoneNumber=${phoneNumber}
//    public HashMap<ArrayList<String>, HashMap<String, List<HashMap<String,String>>>>getLogic(List<String> ccils){
//        ArrayList<String> apiList=new ArrayList<>();
//        HashMap<ArrayList<String>, HashMap<String, List<HashMap<String,String>>>>map1=new HashMap<>();
//        HashMap<String, List<HashMap<String,String>>> map2=new HashMap<>();
//        for(int i=0;i<ccils.size();i++)
//            String s=ccils.get(i).substring(0,ccils.get(i).indexOf(":")+1);
//            String returnParamMap=s.substring(0,s.indexOf("="));
//            String annotation=s.substring(s.indexOf("=")+1,s.indexOf(":"));
//            HashMap<String,String> preApiMap=new HashMap<>();
//            preApiMap.put("returnParamMap",returnParamMap);
//            preApiMap.put("annotation",annotation);
//            String api=ccils.get(i).substring(19,ccils.get(i).indexOf("?"));
//            apiList.add(i,api);
//            String params = ccils.get(i).substring(ccils.get(i).indexOf("?") + 1);
//            String[] paramSimple = params.split("&");
//            HashMap<String,String> dataMap=new HashMap<>();
//            for(String param:paramSimple){
//                //方法参数名
//                String methodParam=param.substring(0,param.indexOf("="));
//                //参数值
//                String dataParam=param.substring(param.indexOf("{")+1,param.indexOf("}"));
//                dataMap.put(methodParam,dataParam);
//            }
//            List<HashMap<String,String>> totalList=new ArrayList<>();
//            totalList.add(0,preApiMap);
//            totalList.add(1,dataMap);
//            map2.put(api,totalList);
//        }
//        map1.put(apiList,map2);
//        return map1;
//    }
}

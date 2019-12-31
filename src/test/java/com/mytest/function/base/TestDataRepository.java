package com.mytest.function.base;

import org.apache.log4j.Logger;
import org.apache.log4j.lf5.util.Resource;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import java.util.stream.Collectors;

public class TestDataRepository {

    List<TestData> allCase;
    Map<String,List<TestData>> subCase;
    private String basePath = "testcase";
    public void loadAll(){
        File file = new File(new Resource(basePath).getURL().getFile());
        File []dirList = file.listFiles();
        Set<TestData> set= new HashSet<TestData>();
        for (File subFile: dirList){
            if(subFile.isDirectory()){
                set.addAll(loadDirTestData(subFile,set));
            }
        }
        allCase = new ArrayList<>(set);
        subCase = allCase.stream().collect(Collectors.groupingBy(TestData::getLogicId));
    }

    public Set<TestData> loadDirTestData(File file,Set<TestData> testData){
        if(file.isDirectory()){
            File[] listFiles = file.listFiles();
            for(File subFile:listFiles){
                loadDirTestData(subFile,testData);
            }
        }else{
            Yaml yaml = new Yaml();
            try {
                if(!file.getName().equals("listCase.yaml")){
                    List<TestData> load = (List<TestData>) yaml.load(new FileInputStream(file));
                    String fileName = file.getName();
                    String filePath = file.getAbsolutePath();
                    final String logicPackagePath = filePath.substring(filePath.indexOf("testcase"),filePath.indexOf(fileName)-1).replace(File.separator,".");
                    load.stream().forEach(data->data.setLogicPackage(logicPackagePath));
                    testData.addAll(load);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return testData;
    }

    public List<TestData> getCaseData(String logicId){

        return null;
    }

    public List<TestData> getCaseData(List<String> caseIds){
        loadAll();
        Set<TestData> dataSet = new HashSet<>();
        for (String caseId:caseIds){
            if(caseId.startsWith(basePath)){
                try {
                    File file = new File(new Resource(caseId.replace(".","/")).getURL().getFile());
                    dataSet.addAll(loadDirTestData(file,new HashSet<>()));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else if(subCase.entrySet().stream().filter(s->s.getKey().equalsIgnoreCase(caseId)).count() > 0){
                dataSet.addAll(subCase.get(caseId));
            }else {
                TestData dataCase = allCase.stream().filter(s->s.getDataId().equalsIgnoreCase(caseId)).findFirst().get();
                if(null != dataCase){
                    dataSet.add(dataCase);
                }
            }
        }
        return new ArrayList<>(dataSet);
    }

    public static void main(String[] args) {
        new TestDataRepository().loadAll();
    }
}

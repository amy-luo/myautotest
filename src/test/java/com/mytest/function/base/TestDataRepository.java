package com.mytest.function.base;

import org.apache.log4j.lf5.util.Resource;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class TestDataRepository {

    List<TestData> allCase;
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
                List<TestData> load = (List<TestData>) yaml.load(new FileInputStream(file));
                String fileName = file.getName();
                String filePath = file.getAbsolutePath();
                final String logicPacagePath = filePath.substring(filePath.indexOf("testcase"),filePath.indexOf(fileName)-1).replace(File.separator,".");
                load.stream().forEach(data->data.setLogicPackage(logicPacagePath));
                testData.addAll(load);
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
        return allCase;
    }

    public static void main(String[] args) {
        new TestDataRepository().loadAll();
    }
}

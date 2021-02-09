package com.mytest.ptbase.Utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * @author LIMSHEN
 * @date 2020/1/3 21:45
 */
public class TestLogic implements Serializable {
    private static final long serialVersionUID = -8000834036334086502L;
    private String logicId;
    private String description;
    private HashMap<String, Object> ccils = new HashMap<>();
    HashMap<String, HashMap<String, String>> logicMap = new HashMap<String, HashMap<String, String>>();
    private String logicPackage;

    //设置并获取LogicPackage
    public String getLogicPackage() {
        return logicPackage;
    }
    public void setLogicPackage(String logicPackage) {
        this.logicPackage = logicPackage;
    }

    //TestData构造器，无参数
    public TestLogic() {}

    //TestData构造器，带参数
    public TestLogic(String logicId, String description,HashMap<String, Object> ccils) {
        this.logicId = logicId;
        this.description = description;
        this.ccils = ccils;
    }

    //设置并获取Ccils()(它是一个HashMap)里面的单个key-value
    public  Object getCcils() { return this.ccils.get("ccils"); }
    public void setCcils(List<String> value) { this.ccils.put("ccils",value);}

    //设置并获取logicId
    public String getDescription() {
        return this.logicId;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogicId() {
        return this.logicId;
    }
    public void setLogicId(String logicId) {
        this.logicId = logicId;
    }

    public int hashCode() {
        return (this.logicId).hashCode();
    }
    public boolean equals(Object obj) {
        if (!(obj instanceof TestLogic)) {
            return false;
        } else {
            String id = ((TestLogic)obj).logicId ;
            return id.equals(this.logicId);
        }
    }

    //testData对象的toString方法，返回String "TestData[dataId logicId description]"
    @Override
    public String toString() {
        String model = "TestLogic[%s %s]";
        return String.format(model,logicId,description);
    }

}

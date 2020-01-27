package com.mytest.function.Utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TestData implements Serializable {

        private static final long serialVersionUID = -8000834036334086507L;
        private String dataId;
        private String logicId;
        private transient Map<String, Object> dataItems = new HashMap();
        private boolean dataCache;
        private String description;
        private String isRun;
        private String fileName;
        private String logicPackage;

    public String getLogicPackage() {
        return logicPackage;
    }

    public void setLogicPackage(String logicPackage) {
        this.logicPackage = logicPackage;
    }

    public TestData() {
    }
    public TestData(String dataId,String logicId,String description) {
        this.dataId = dataId;
        this.logicId = logicId;
        this.description = description;
    }

        public TestData copy() {
        TestData result = new TestData();
        result.dataId = this.dataId;
        result.logicId = this.logicId;
        result.dataItems.putAll(this.dataItems);
        result.description = this.description;
        result.isRun = this.isRun;
        result.fileName = this.fileName;
        return result;
    }

        public Object getDataItem(String name) {
        return this.dataItems.get(name);
    }

        public void setDataItem(String name, Object dataItem) {
        this.dataItems.put(name, dataItem);
    }

    public boolean isDataCache() {
        return dataCache;
    }

    public void setDataCache(boolean dataCache) {
        this.dataCache = dataCache;
    }

    public String getLogicId() {
        return this.logicId;
    }

        public void setLogicId(String logicId) {
        this.logicId = logicId;
    }

        public Map<String, Object> getDataItems() {
        return this.dataItems;
    }

        public void setDataItems(Map<String, Object> dataItems) {
        this.dataItems = dataItems;
    }

        public String getDataId() {
        return this.dataId;
    }

        public void setDataId(String dataId) {
        this.dataId = dataId;
    }

        public String getDescription() {
        return this.description;
    }

        public void setDescription(String description) {
        this.description = description;
    }

        public String getIsRun() {
        return this.isRun;
    }

        public void setIsRun(String isRun) {
        this.isRun = isRun;
    }

        public String getFileName() {
        return this.fileName;
    }

        public void setFileName(String fileName) {
        this.fileName = fileName;
    }

        public int hashCode() {
        return (this.logicId + this.dataId).hashCode();
    }

        public boolean equals(Object obj) {
        if (!(obj instanceof TestData)) {
            return false;
        } else {
            String id = ((TestData)obj).logicId + ((TestData)obj).dataId;
            return id.equals(this.logicId + this.dataId);
        }
    }

    @Override
    public String toString() {
        String model = "TestData[%s %s]";
        return String.format(model,dataId,description);
    }
}

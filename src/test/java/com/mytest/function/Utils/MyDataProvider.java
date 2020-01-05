package com.mytest.function.Utils;

import java.util.Iterator;
import java.util.List;

public class MyDataProvider implements Iterator<Object[]>{

    private final Iterator<TestData> testDatas;
    public MyDataProvider(List<TestData> testData){
        this.testDatas = testData.iterator();
    }

    public boolean hasNext() {
        return this.testDatas.hasNext();
    }

    public Object[] next() {
        return new Object[]{this.testDatas.next()};
    }

    public void remove() {
        this.testDatas.remove();
    }
}

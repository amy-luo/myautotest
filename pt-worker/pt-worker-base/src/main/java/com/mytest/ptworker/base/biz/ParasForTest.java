package com.mytest.ptworker.base.biz;

import org.springframework.stereotype.Component;
/**每台Worker的入参，从zk同步过来之后，修改该类的参数*/
@Component
public class ParasForTest {
//    public static String tcId="";
    public static Integer cyclesCount=0;
    public static Integer threadCount=0;
    public static boolean status=true;

    /**在开启压测或更改压测时，将从zk中同步过来的时间加上3s；*/
    public static long st=0L;
}

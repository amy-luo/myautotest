package com.mytest.function.api.xueqiu;

import com.alibaba.fastjson.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.math.BigDecimal;
import java.util.*;

public class PE_PB_Time {
    protected static final Logger logger= LoggerFactory.getLogger(PE_PB_Time.class);

    public ArrayList<Map<String, Double>> getAllPE(ArrayList<String> symbols) {
        ArrayList<Map<String, Double>> peList = new ArrayList<Map<String, Double>>();
        ArrayList<Map<String, Double>> pbList = new ArrayList<Map<String, Double>>();
        ArrayList<Map<String, Double>> market_capitalList = new ArrayList<Map<String, Double>>();
        for (String symbol : symbols) {
//        String symbol = "SH000905";
            Long begin = 1596169455875L;
            String period = "month";
            String type = "before";
            int count = -304;
            String indicator = "kline,pe,pb,ps,pcf,market_capital,agt,ggt,balance";
            GetDataEach getDataEach = new GetDataEach();
            Map<String, Double> peMap = new HashMap<>();
            Map<String, Double> pbMap = new HashMap<>();
            Map<String, Double> market_capitalMap = new HashMap<>();
            Map<String, Map<String, Object>> map = getDataEach.getDataEach(symbol, begin, period, type, count, indicator);
            for (String key : map.keySet()) {
                for (Map.Entry entry : map.get(key).entrySet()) {
                    if (entry.getKey().equals("pe")) {
                        peMap.put(key, (Double) entry.getValue());
                    }
                    if (entry.getKey().equals("pb")) {
                        pbMap.put(key, (Double) entry.getValue());
                    }
                    if (entry.getKey().equals("market_capital")) {
                        market_capitalMap.put(key, (Double) entry.getValue());
                    }
                }
            }
            peList.add(peMap);
            pbList.add(pbMap);
            market_capitalList.add(market_capitalMap);
        }
        return peList;
    }

    public Map<String, Double> calculatePE() {
        Map<String, Double> pe_avg_map = new HashMap<>();
        ArrayList<String> symbols = new ArrayList<>();
        symbols.add("SH000905");
        ArrayList<Map<String, Double>> peList = this.getAllPE(symbols);
        Object[] keySet = peList.get(0).keySet().toArray();
        Double countPE = 0.0;
        //计算PE算术平均值,与日期的对应关系
        for (Object date : keySet) {
            for (Map<String, Double> submap : peList) {
                countPE += submap.get(date);
            }
            pe_avg_map.put(date.toString(), countPE / (peList.size()));
        }
        return pe_avg_map;
    }
    public Map<String, ArrayList<Double>> calculatePePbAvg(ArrayList<String> symbols) {
        ArrayList<Map<String, Map<String, Object>>> allDataList = new ArrayList<Map<String, Map<String, Object>>>();
        for (String symbol : symbols) {
//        String symbol = "SH000905";
            Long begin = 1596169455875L;
            String period = "month";
            String type = "before";
            int count = -304;
            String indicator = "kline,pe,pb,ps,pcf,market_capital,agt,ggt,balance";
            GetDataEach getDataEach = new GetDataEach();
            Map<String, Map<String, Object>> map = getDataEach.getDataEach(symbol, begin, period, type, count, indicator);
            allDataList.add(map);
        }
        //所有symbol的时间set
        Object[] dates = allDataList.get(0).keySet().toArray();

        //计算PE/PB的算术平均值和加权平均值,与日期的对应关系
        Map<String, ArrayList<Double>> dateMap=new HashMap<>();
        for (Object date : dates) {
            BigDecimal total_market_capital=new BigDecimal(0);
            double avg_pe=0.0;
            double total_pe=0.0;

            String jiaquan_avg_pe="";
            BigDecimal total_jiaquan_pe=new BigDecimal(0);

            double avg_pb=0.0;
            double total_pb=0.0;

            String jiaquan_avg_pb="";
            BigDecimal total_jiaquan_pb=new BigDecimal(0);
            int count=allDataList.size();
            for (Map<String, Map<String, Object>> submap:allDataList) {
                //找出单个的pe/pb/market_capital
                BigDecimal pe=new BigDecimal(0);
                BigDecimal pb=new BigDecimal(0);
                BigDecimal market_capital=new BigDecimal(0);
                if(null == submap.get(date.toString())){count=count-1;}
                if (null != submap.get(date.toString())) {
                    for (Map.Entry entry : (submap.get(date.toString())).entrySet()) {
                        String sk=String.valueOf(entry.getKey());
                        String sv=String.valueOf(entry.getValue());
                        if (entry.getKey().toString().equals("pe")) {
                            if (null != entry.getValue()) {
                                pe = (BigDecimal)entry.getValue();
//                                logger.info(pe.toString());
                                total_pe += Double.parseDouble(pe.toString());
                            }
                        }
                        if (entry.getKey().toString().equals("pb")) {
                            if (null != entry.getValue()) {
                                pb = (BigDecimal)entry.getValue();
//                                logger.info(pb.toString());
                                total_pb += Double.parseDouble(pb.toString());
                            }
                        }
                        if (entry.getKey().toString().equals("market_capital")) {
                            if (null != entry.getValue()) {
                                market_capital = (BigDecimal)entry.getValue();
//                                logger.info(market_capital.toString());
                                if(null!=market_capital) {
                                    total_market_capital=total_market_capital.add(market_capital);
                                }
                            }
                        }
                    }
                }
                if(null!=pe&&null!=market_capital){
                    total_jiaquan_pe=total_jiaquan_pe.add(pe.multiply(market_capital));
//                    logger.info(total_jiaquan_pe.toString());
                }
                if(null!=pb&&null!=market_capital) {
                    total_jiaquan_pb=total_jiaquan_pb.add(pb.multiply(market_capital));
//                    logger.info(total_jiaquan_pb.toString());
                }
            }
            avg_pe=total_pe/count;
            if(null!=total_jiaquan_pe&&null!=total_market_capital) {
                jiaquan_avg_pe = String.valueOf((total_jiaquan_pe.divide(total_market_capital, 6, BigDecimal.ROUND_HALF_UP).toString()));
//                logger.info(jiaquan_avg_pe);
            }
            avg_pb=total_pb/count;
            if(null!=total_jiaquan_pb&&null!=total_market_capital) {
                jiaquan_avg_pb = String.valueOf((total_jiaquan_pb.divide(total_market_capital, 6, BigDecimal.ROUND_HALF_UP).toString()));
//                logger.info(jiaquan_avg_pb);
            }
            ArrayList peAndPbAverage = new ArrayList<String>();
            peAndPbAverage.add(avg_pe);
            peAndPbAverage.add(jiaquan_avg_pe);
            peAndPbAverage.add(avg_pb);
            peAndPbAverage.add(jiaquan_avg_pb);
            logger.info("日期为："+date+"\nPE算术平均值为："+avg_pe+"\nPE加权平均值为："+jiaquan_avg_pe+ "\nPB算术平均值为："+avg_pb+"\nPB加权平均值为："+jiaquan_avg_pb+"\n总市值为："+total_market_capital);
            dateMap.put(date.toString(),peAndPbAverage);
            logger.info(dateMap.toString());
        }
        return dateMap;
    }

    public static void main(String[] args){
        PE_PB_Time pe_pb_time=new PE_PB_Time();
        ArrayList<String> symbols=new ArrayList<>();
        symbols.add("SZ000768");
        symbols.add("SH600760");
        pe_pb_time.calculatePePbAvg(symbols);
    }
}


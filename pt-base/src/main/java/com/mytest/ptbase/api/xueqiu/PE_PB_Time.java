package com.mytest.ptbase.api.xueqiu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;
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
    public Map<String, ArrayList<BigDecimal>> calculatePePbAvg(ArrayList<String> symbols) {
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
        ArrayList<String> dates=new ArrayList();
        dates.addAll(allDataList.get(0).keySet());

        //计算PE/PB的算术平均值和加权平均值,与日期的对应关系
        Map<String, ArrayList<BigDecimal>> dateMap=new HashMap<>();

        ArrayList<BigDecimal> peList_dengquan = new ArrayList<>();//所有日期的指数等权平均pe
        ArrayList<BigDecimal> peList_jiaquan = new ArrayList<>();//所有日期的指数加权平均pe
        ArrayList<BigDecimal> pbList_dengquan = new ArrayList<>();//所有日期的指数加权平均pb
        ArrayList<BigDecimal> pbList_jiaquan = new ArrayList<>();//所有日期的指数加权平均pb
        //遍历一个股票的所有指标，针对某一个股票的键值对，key是date，针对某一天
        for (Object date : dates) {

            BigDecimal market_capital_sum=new BigDecimal(0);//总市值（总股本）之和
            BigDecimal close_sum=new BigDecimal(0);//个股总价之和
            BigDecimal jingLiRun_sum=new BigDecimal(0);//每股净利润之和，每股净利润=（每股价格close）/（市盈率pe）
            BigDecimal jingLiRun_guben_sum=new BigDecimal(0);//净利润*股本和
            BigDecimal jingZiChan_sum=new BigDecimal(0);//每股净资产之和，每股净资产=（每股价格close）/（市净率pb）
            BigDecimal jingZiChan_guben_sum=new BigDecimal(0);//净资产*股本和
            int amount = allDataList.size();
            //遍历所有的股票，对某一个股票的某一天
            for (Map<String, Map<String, Object>> submap : allDataList) {
                BigDecimal pe = new BigDecimal(0);
                BigDecimal pb = new BigDecimal(0);
                BigDecimal close = new BigDecimal(0);
                BigDecimal market_capital = new BigDecimal(0);
                if (null == submap.get(date.toString())) {
                    amount = amount - 1;
                }
                if (null != submap.get(date.toString())) {
                    //找出单个股票的的pe/pb/market_capital/close
                    if (null != submap.get(date.toString()).get("close")) {
                        close = (BigDecimal) submap.get(date.toString()).get("close");
                        close_sum=close_sum.add(close);
                    }
                    if (null != submap.get(date.toString()).get("pe")) {
                        pe = (BigDecimal) submap.get(date.toString()).get("pe");
                    }
                    if (null != submap.get(date.toString()).get("pb")) {
                        pb = (BigDecimal) submap.get(date.toString()).get("pb");
                    }
                    if (null != submap.get(date.toString()).get("market_capital")) {
                        market_capital = (BigDecimal) submap.get(date.toString()).get("market_capital");
                        market_capital_sum=market_capital_sum.add(market_capital);
                    }
                    if(!(pe.toString().equals("0"))&&!(pb.toString().equals("0"))&&!(close.toString().equals("0"))) {
                        BigDecimal zongGuBen = market_capital.divide(close, 6, BigDecimal.ROUND_HALF_UP);
                        BigDecimal jingLiRun = close.divide(pe, 6, BigDecimal.ROUND_HALF_UP);//每股净利润之和，每股净利润=（每股价格close）/（市盈率pe）
                        BigDecimal jingLiRun_guben = jingLiRun.multiply(zongGuBen);//净利润*股本和
                        BigDecimal jingZiChan = close.divide(pb, 6, BigDecimal.ROUND_HALF_UP);//每股净资产之和，每股净资产=（每股价格close）/（市净率pb）
                        BigDecimal jingZiChan_guben = jingZiChan.multiply(zongGuBen);//净资产*股本和
                        jingLiRun_sum = jingLiRun_sum.add(jingLiRun);
                        jingLiRun_guben_sum = jingLiRun_guben_sum.add(jingLiRun_guben);
                        jingZiChan_sum = jingZiChan_sum.add(jingZiChan);
                        jingZiChan_guben_sum = jingZiChan_guben_sum.add(jingZiChan_guben);
                    }
                }
            }
            BigDecimal avg_pe=close_sum.divide(jingLiRun_sum,6,BigDecimal.ROUND_HALF_UP); //等权pe平均值,总价格/总利润
            BigDecimal avg_pb=close_sum.divide(jingZiChan_sum,6,BigDecimal.ROUND_HALF_UP); //等权pb平均值，总价格/总净资产
            BigDecimal jiaquan_avg_pe=market_capital_sum.divide(jingLiRun_guben_sum,6,BigDecimal.ROUND_HALF_UP); //加权pe平均值,（总市值之和）/（（净利润*总股本）之和）
            BigDecimal jiaquan_avg_pb=market_capital_sum.divide(jingZiChan_guben_sum,6,BigDecimal.ROUND_HALF_UP); ; //加权pb平均值，（总市值之和）/（（净资产*总股本）之和）

            peList_dengquan.add(avg_pe);//所有日期的指数等权平均pe
            peList_jiaquan.add(jiaquan_avg_pe);//所有日期的指数加权平均pe
            pbList_dengquan.add(avg_pb);//所有日期的指数加权平均pb
            pbList_jiaquan.add(jiaquan_avg_pb);//所有日期的指数加权平均pb

            ArrayList<BigDecimal> peAndPbAverage = new ArrayList<>();
            peAndPbAverage.add(0,avg_pe);
            peAndPbAverage.add(1,jiaquan_avg_pe);
            peAndPbAverage.add(2,avg_pb);
            peAndPbAverage.add(3,jiaquan_avg_pb);
            logger.info("日期为："+date+"\nPE算术平均值为："+avg_pe+"\nPE加权平均值为："+jiaquan_avg_pe+"\nPB算术平均值为："+avg_pb+"\nPB加权平均值为："+jiaquan_avg_pb);
            dateMap.put(date.toString(),peAndPbAverage);
        }

        BigDecimal maxPE_dengquan=Collections.max(peList_dengquan);
        BigDecimal minPE_dengquan=Collections.min(peList_dengquan);
        BigDecimal maxPE_jiaquan=Collections.max(peList_jiaquan);
        BigDecimal minPE_jiaquan=Collections.min(peList_jiaquan);
        BigDecimal maxPB_dengquan=Collections.max(pbList_dengquan);
        BigDecimal minPB_dengquan=Collections.min(pbList_dengquan);
        BigDecimal maxPB_jiaquan=Collections.max(pbList_jiaquan);
        BigDecimal minPB_jiaquan=Collections.min(pbList_jiaquan);

        BigDecimal currentPE_dengquan=dateMap.get(Collections.max(dateMap.keySet())).get(0);
        BigDecimal currentPE_jiaquan=dateMap.get(Collections.max(dateMap.keySet())).get(1);
        BigDecimal currentPB_dengquan=dateMap.get(Collections.max(dateMap.keySet())).get(2);
        BigDecimal currentPB_jiaquan=dateMap.get(Collections.max(dateMap.keySet())).get(3);

        BigDecimal pe_baifen_dengquan=(currentPE_dengquan.subtract(minPE_dengquan)).divide(maxPE_dengquan.subtract(minPE_dengquan),6,BigDecimal.ROUND_HALF_UP); //当前等权pe百分位
        BigDecimal pb_baifen_dengquan=(currentPB_dengquan.subtract(minPB_dengquan)).divide(maxPB_dengquan.subtract(minPB_dengquan),6,BigDecimal.ROUND_HALF_UP); //当前等权pb百分位
        BigDecimal pe_baifen_jiaquan=(currentPE_jiaquan.subtract(minPE_jiaquan)).divide(maxPE_jiaquan.subtract(minPE_jiaquan),6,BigDecimal.ROUND_HALF_UP); //当前加权pe百分位
        BigDecimal pb_baifen_jiaquan=(currentPB_jiaquan.subtract(minPB_jiaquan)).divide(maxPB_jiaquan.subtract(minPB_jiaquan),6,BigDecimal.ROUND_HALF_UP); //当前加权pb百分位

        ArrayList<BigDecimal> baifenwei=new ArrayList<>();
        baifenwei.add(0,pe_baifen_dengquan);
        baifenwei.add(1,pe_baifen_jiaquan);
        baifenwei.add(2,pb_baifen_dengquan);
        baifenwei.add(3,pb_baifen_jiaquan);
        dateMap.put("PE百分位",baifenwei);
        return dateMap;
    }

    public static void main(String[] args) throws IOException {
        PE_PB_Time pe_pb_time=new PE_PB_Time();
//        String filePath="D:\\通达信\\T0002\\export\\上证5020200730.XLSX";
//        String filePathForWrite="D:\\通达信\\T0002\\export\\上证50统计.XLSX";
//        String filePath="D:\\通达信\\T0002\\export\\中证50020200730.XLSX";
//        String filePathForWrite="D:\\通达信\\T0002\\export\\中证500统计.XLSX";
        String filePath="D:\\通达信\\T0002\\export\\沪深30020200730.XLSX";
        String filePathForWrite="D:\\通达信\\T0002\\export\\沪深300统计.XLSX";
        GetZhongZheng500Codes getZhongZheng500Codes=new GetZhongZheng500Codes();
        ArrayList<String> symbols=getZhongZheng500Codes.codesForZhongZheng500(filePath);
        Map<String, ArrayList<BigDecimal>> dateMap=pe_pb_time.calculatePePbAvg(symbols);
        PoiWriteUtil poiWriteUtil=new PoiWriteUtil();
        poiWriteUtil.poiWrite(filePathForWrite,dateMap);
    }
}

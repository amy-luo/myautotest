package com.mytest.ptbase.api.niuke;

import java.util.*;

//组装最大可靠性设备,https://renjie.blog.csdn.net/article/details/130921467
//设备按类型分组，分组后进行全排列（递归回溯），找出最大的可靠性值。也可以根据可靠性来进行二分查找法，比全排列更优，需要进行排序。
public class KeKaoXingZuiDaDongTai {
    public static ArrayList<Integer> kekaoxingMax;
    public static HashMap<Integer,ArrayList<int[]>> map;
    public static ArrayList<ArrayList<int[]>> list2;
    public static int t;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        kekaoxingMax=new ArrayList<>();

        String[] a = in.nextLine().split(" ");
        int m=Integer.valueOf(a[0]);
        t=Integer.valueOf(a[1]);
        int n=Integer.valueOf(in.nextLine());
        map=new HashMap<>();//key,设备类型，VALUE是设备数据，0是可靠性，1是price，
        int minKe=999999999;
        int maxKe=0;
        for(int i=0;i<n;i++){
            String[] s=in.nextLine().split(" ");
                Integer.valueOf(s[0]);
                minKe=Math.min(minKe,Integer.valueOf(s[1]));
                maxKe=Math.max(maxKe,Integer.valueOf(s[1]));
                int[] ar=new int[]{Integer.valueOf(s[1]),Integer.valueOf(s[2])};
                ArrayList list=map.getOrDefault(Integer.valueOf(s[0]),new ArrayList<int[]>());
                list.add(ar);
                map.put(Integer.valueOf(s[0]),list);
        }
        list2=new ArrayList<>();
        for(ArrayList<int[]> o:map.values()){
            Collections.sort(o,(Comparator.comparingInt(o1 -> o1[0])));
            list2.add(o);
        }
        int k=0;
        int sum=0;
        int kekaoxing=0;
        //递归回溯，全排列的方法
//        backTrack(k,sum,kekaoxing,m);
//        if(kekaoxingMax.size()==0){System.out.println(-1);}else {
//            System.out.println(Collections.max(kekaoxingMax));
//        }

        //二分查找法

        int left=minKe;
        int right=maxKe;
        int maxkK=-1;
        while(left<=right){
            int mid=(left+right)/2;
            int isPass=erfenFind(mid,m);
            if(isPass!=-1) {
                maxkK=mid;
                left = mid + 1;
            }else{
                right=mid-1;
            }
        }
        System.out.println(maxkK);
    }

    private static void backTrack(int k,int sum,int kekaoxing,int m){
        if(sum>m){return;}
        if(k==t){kekaoxingMax.add(kekaoxing);return;}//结束条件，一定要记得加return;
        ArrayList<int[]> list3=list2.get(k);
        for(int i=0;i<list3.size();i++){
            if(kekaoxing==0){kekaoxing=list3.get(i)[0];}
            int kekaoxing_dangqian=list3.get(i)[0];
            int sum2=sum+list3.get(i)[1];
            backTrack(k+1,sum2,Math.min(kekaoxing,kekaoxing_dangqian),m);//不改动当前属性值的写法
        }
    }

//    二分查找法
   private static int erfenFind(int mid,int m){
        int sum=0;
        int minKKxing=mid;
        for(ArrayList<int[]> typeShebeilist:list2){
            boolean flag=false;
            for(int[] typeShebei:typeShebeilist){
                if(typeShebei[0]>=mid){
                    sum+=typeShebei[1];
                    flag=true;
                    minKKxing=Math.min(minKKxing,typeShebei[0]);
                    if(sum>m){return -1;}
                    break;
                }
            }
            if(!flag){return -1;};
        }
        return minKKxing;
   }
}

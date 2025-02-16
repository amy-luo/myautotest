package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//https://renjie.blog.csdn.net/article/details/128132107
//最大社交距离,过程模拟。记录进来人后，座位的状态。根据已有座位状态，算出下一个进来的状态，每次都要遍历找到最大间距。
//有很多细节需要考虑。
public class ZuiDaSheJiaoJuLi {
    public static int[][] matrix;
    public static ArrayList<Boolean> seatStatus;
    public static int m;

    //    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            m = Integer.valueOf(in.nextLine());
            String s=in.nextLine();
            int[] jinchu = Arrays.stream(s.substring(1,s.length()-1).split(",")).mapToInt(Integer::parseInt).toArray();
            seatStatus = new ArrayList<>();
            for(int i=0;i<m;i++){
                seatStatus.add(i, false);
            }

            for (int i = 0; i < jinchu.length; i++) {
                if(jinchu[i]==1){
                    int index=getIndex();
                    if(index==-1){System.out.println(-1);break;}//座位满了，返回-1；
                    seatStatus.set(index, true);//修改座位状态
                    if(i==jinchu.length-1){System.out.println(index);break;}
                }else if(jinchu[i]<=0){
                    seatStatus.set(Math.abs(jinchu[i]),false);//修改座位状态
                }
            }
        }
    }

    private static int getIndex() {
        int left = 0;
        int maxJu = 0;
        int maxJuIndex = 0;//左，右，中
        if(!seatStatus.contains(true)){return 0;}//如果全没坐人，那么可以直接坐到第一个位置。
        if(!seatStatus.contains(false)){return -1;}//如果坐满了人，那么返回-1,没有座位可做。
//        boolean flag=false;
        for (int i = 1; i < m; i++) {
            if (seatStatus.get(i)) {
                int jianju=(i - left) / 2;//已坐的相邻两个座位之间间距/2，就可能是放置下一个元素的索引。比较得出最大间距/2的最小索引。
                if (jianju!=0&&jianju > maxJu) {
                    maxJu = jianju;//找出最大间距/2
                    maxJuIndex = left + maxJu;//可能是放置下一个元素的索引
                }
                if(left==0&&!seatStatus.get(left)){//当第一个元素没有坐时，它和后面的间距不需要除以2，特殊处理
                    jianju=i-left;
                    if (jianju > maxJu) {
                        maxJu = jianju;
                        maxJuIndex=0;
                    }
                }
                left = i;//每找到一个已坐的，左指针就要移动一下，方便计算下个间距
            }

            if(i==m-1&&!seatStatus.get(i)){//当最后一个元素没有坐时，它和前面的间距不需要除以2，特殊处理
                int jianju=i-left;
                if (jianju > maxJu) {
                    maxJu = jianju;
                    maxJuIndex=m-1;
                }
            }
        }
        return maxJuIndex;
    }
}

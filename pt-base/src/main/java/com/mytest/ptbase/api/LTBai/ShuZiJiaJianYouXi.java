package com.mytest.ptbase.api.LTBai;

import java.util.Scanner;

//数字加减游戏
public class ShuZiJiaJianYouXi {
    public static int s;
    public static int t;
    public static int a;
    public static int b;
    public static int countA;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        s = in.nextInt();
         t = in.nextInt();
         a = in.nextInt();
         b = in.nextInt();
         countA=((t-s)%b)/a;
        diugiab();
         System.out.println(countA);
    }

    private static void diugiab(){
        while(true) {
//            if (s < t) {
                if ((t - countA * a - s) % b == 0) {
                    break;
                }
                if ((t + countA * a - s) % b == 0) {
                    break;
                } else {
                    countA++;
                }
//            }
//            if (s > t) {
//                if ((s - countA * a - t) % b == 0) {
//                    break;
//                }
//                if ((s + countA * a - t) % b == 0) {
//                    break;
//                } else {
//                    countA++;
//                }
//            }
            if (s == t) {
                break;
            }
        }
    }
}

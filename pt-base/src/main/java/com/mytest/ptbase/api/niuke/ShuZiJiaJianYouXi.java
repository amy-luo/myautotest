package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Scanner;

import static com.mytest.ptbase.api.niuke.PingLunDiGui.count;
import static com.mytest.ptbase.api.niuke.PingLunDiGui.digui;

//自由练习
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

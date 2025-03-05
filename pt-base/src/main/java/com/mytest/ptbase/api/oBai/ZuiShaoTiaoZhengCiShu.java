package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

//最小的调整次数,学生重新排队、小朋友分组最少调整次数，https://renjie.blog.csdn.net/article/details/136353105
//一个数组存放学生的组号，遍历，仔细分析场景。
// 当和后面一个同组，1=2!=3,在3之前插入跟1,2同组的元素。1!=2=3,,1=3!=2,将不等于的1或者2移走，移到它的同组元素，再把23或13拼回queue，等着下次循环。
// 当后后面两个同组，调整0次
// 当和后面没有同组的调整2次。
// 调整后，删除元素，重新开始又从0开始。
public class ZuiShaoTiaoZhengCiShu {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            //String s=in.nextLine();
//            int m = Integer.valueOf(s[0]);
//            int n = Integer.valueOf(s[1]);
            int[] duilie = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] fenzu = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int max = Arrays.stream(duilie).max().getAsInt();
            int[] ar1 = new int[max + 1];//组名
            for (int i = 0; i < fenzu.length; i = i + 3) {
                ar1[fenzu[i]] = i/3;
                ar1[fenzu[i + 1]] = i/3;
                ar1[fenzu[i + 2]] = i/3;
            }
            LinkedList<Integer> deque = new LinkedList<>();
            for (int i = 0; i < duilie.length; i++) {
                deque.addLast(duilie[i]);
            }
            int count = 0;
            for (int i=0;i<deque.size();i++) {
                LinkedList<Integer> deque2 = new LinkedList<>();
                int tmp = deque.pollFirst();
                int tmp2 = deque.pollFirst();
                int tmp3 = deque.pollFirst();
                if (ar1[tmp] == ar1[tmp2] && ar1[tmp] == ar1[tmp3]) {//三个元素相等，1=2=3
                    continue;
                }
                if (ar1[tmp] == ar1[tmp2] && ar1[tmp] != ar1[tmp3]) {//三个元素：1=2,2!=3,在两个相等元素后面移入同组元素
                    deque2.addLast(tmp3);
                    while (!deque.isEmpty()) {
                        int tmp4 = deque.pollFirst();
                        deque2.addLast(tmp4);
                        if (ar1[tmp4] == ar1[tmp]) {
                            count++;
                            deque2.pollLast();
                            deque.addAll(0, deque2);
                            deque2.removeAll(deque2);
                            break;
                        }
                    }
                }
                if (ar1[tmp] != ar1[tmp2] && ar1[tmp] == ar1[tmp3]) {//三个元素：1!=2,1=3，移走不相等的元素到它的同组
                    deque2.addFirst(tmp);
                    deque2.addFirst(tmp3);
                    while (!deque.isEmpty()) {
                        int tmp4 = deque.pollFirst();
                        deque2.addLast(tmp4);
                        if (ar1[tmp4] == ar1[tmp2]) {
                            count++;
                            deque2.addLast(tmp2);
                            deque.addAll(0, deque2);
                            deque2.removeAll(deque2);
                            break;
                        }
                    }
                }
                if (ar1[tmp] != ar1[tmp2] && ar1[tmp2] == ar1[tmp3]) {//三个元素：1!=2,2=3，移走不相等的元素到它的同组
                    deque2.addFirst(tmp2);
                    deque2.addFirst(tmp3);
                    while (!deque.isEmpty()) {
                        int tmp4 = deque.pollFirst();
                        deque2.addLast(tmp4);
                        if (ar1[tmp4] == ar1[tmp]) {
                            count++;
                            deque2.addLast(tmp);
                            deque.addAll(0, deque2);
                            deque2.removeAll(deque2);
                            break;
                        }
                    }
                }
                if (ar1[tmp] != ar1[tmp2] && ar1[tmp2] != ar1[tmp3] && ar1[tmp] != ar1[tmp3]) {//三个元素不相等：1!=2,2!=3,1!=3,挪来两个跟1同组的元素
                    deque2.addLast(tmp2);
                    deque2.addLast(tmp3);
                    int cal = 0;
                    while (!deque.isEmpty()) {
                        int tmp4 = deque.pollFirst();
                        deque2.addLast(tmp4);
                        if (ar1[tmp4] == ar1[tmp]) {
                            cal++;
                            count++;
                            deque2.pollLast();
                            if (cal == 2) {//需要调整两次
                                deque.addAll(0, deque2);
                                deque2.removeAll(deque2);
                                break;
                            }
                        }

                    }
                }
            }
            System.out.println(count);
        }
    }

}

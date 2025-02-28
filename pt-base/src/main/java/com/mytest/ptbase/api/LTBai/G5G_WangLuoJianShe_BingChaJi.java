package com.mytest.ptbase.api.LTBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//5G网络建设,https://renjie.blog.csdn.net/article/details/135095195
//并查集，维护一个元素的根节点结合，有相同根节点的集合是相连的。以此来判断元素是否相连。
//并查集还需要多看看，细细体会，加深印象。多个元素互相关联，可以使用并查集，注意使用场景。
public class G5G_WangLuoJianShe_BingChaJi {
    public static int[][] matrix;
    public static int[] root;
    public static int res;
    public static int count;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int m = Integer.valueOf(in.nextLine());
            int n = Integer.valueOf(in.nextLine());
            root = new int[m+1];//维护并查集，索引代表设备，每个索引的根节点首先指向索引自己，后续将根节点改成别的索引(设备)。
            for (int i = 0; i < m+1; i++) {
                root[i] = i;
            }
            matrix = new int[n][3];
            count=0;//设置初始值
            for (int i = 0; i < n; i++) {
                int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                if (dataArray[3] == 1) {
                   if(find(dataArray[0]) != find(dataArray[1])) {//先判断下并查集中是否已存在关联关系，去除重复合并，如果已有联系那么无需再合并，不然count会多加
                       merge(dataArray[0], dataArray[1]);//在并查集中存储关联关系，修改根节点，指向同一个根节点（同左边的根节点）
                   }
                }
                matrix[i] = new int[]{dataArray[0], dataArray[1], dataArray[2]};
            }
            Arrays.sort(matrix, Comparator.comparingInt(o -> o[2]));//按价格从小到大排序
            res = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (find(matrix[i][0]) != find(matrix[i][1])) {//如果并查集中没有关联关系，那就他们之前就要架光纤，加上最低的价格。
                    res += matrix[i][2];
                    merge(matrix[i][0], matrix[i][1]);//加光纤后就关联起来了，在并查集中修改根节点，使之关联
                    if(count==m-1){break;}//总计关联m-1个光纤后，所有的光纤就关联起来了就可以结束任务了。
                }
            }
            if(count!=m-1){res=-1;}//如果关联光纤的数目少于m-1，说明有些光纤无法被关联进来，返回-1
            System.out.println(res);
        }
    }

    private static int find(int x) {
        if (root[x] == x) {
            return root[x];
        } else {
            return find(root[x]);
        }
    }

    private static void merge(int x, int y) {
        int new_x = find(root[x]);
        int new_y = find(root[y]);
        root[new_y] = new_x;//向左合并
        count++;//计算关联光纤的次数
    }

}

package com.mytest.ptbase.api.niuke;

import com.alibaba.fastjson.JSONObject;
import com.sun.corba.se.impl.orbutil.ObjectUtility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//中文分词模拟器,https://renjie.blog.csdn.net/article/details/135507826
//动态规划，巧妙的动态规划。后续的单词合并更难，细节非常多。
//非常难，单词合并处理
public class ZhongWenFenCiMoNiQi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] strArray = in.nextLine().split(",");
            StringBuilder stbZong = new StringBuilder();
            String[] ziDian = in.nextLine().split(",");
            List<String> list = Arrays.asList(ziDian);
            for(String str:strArray) {
                ArrayList<String> outputDanci = new ArrayList<>();
                boolean[] dp = new boolean[str.length() + 1];//动态规划，第i个元素是否可以切割。由前个可切割元素与第i个元素之间的字符串是否是单词来决定
                dp[0] = true;
                for (int i = 1; i < str.length() + 1; i++) {
                    for (int j = 0; j < i; j++) {
                        dp[i] = dp[j] && list.contains(str.substring(j, i));
                        if (dp[i]) {
                            break;
                        }
                    }
                }
                ArrayList<Integer> indexList = new ArrayList<>();
                for (int i = 1; i < dp.length; i++) {
                    if (dp[i]) {
                        indexList.add(i);
                    }
                }
                //处理单词合并
                for (int i = 0; i < indexList.size(); ) {//左指针，i的值的更新有j的表现来控制。
                    int index = i + 1;//初始化下一个i指针
                    StringBuilder stb = new StringBuilder();
                    stb.append(str, i == 0 ? 0 : indexList.get(i - 1), indexList.get(i));
                    String res = stb.toString();//存放找到的合并结果，初始值为当前i索引单词
                    for (int j = i + 1; j < indexList.size(); j++) {//右指针
                        int begin = indexList.get(j - 1);
                        int after = indexList.get(j);
                        stb.append(str, begin, after);
                        if (list.contains(stb.toString())) {
                            res = stb.toString();
                            index = j + 1;//更新最新有效右指针，用来给到下一次i
                        }
                    }
                    outputDanci.add(res);//添加最后的合并结果
                    i = index;//合并后将有效的右指针传给左指针
                }
//          String qi=JSONObject.toJSONString(dp);
                for (String o : outputDanci) {
                    stbZong.append(o).append(",");
                }
                //当dp中的最后一个不为true时，代表最后有些字符没有被字典匹配到。
                if (!dp[dp.length - 1]) {//当dp中的最后一个不为true时，代表最后有些字符没有被字典匹配到。
                    //从最后一个true的索引到最后一个索引，都要以单个字符输出,如果没有true就从头开始
                    for (int i = indexList.isEmpty()?0:indexList.get(indexList.size() - 1); i <= dp.length - 2; i++) {
                        stbZong.append(str.charAt(i)).append(",");
                    }
                }
            }
            System.out.println(stbZong.toString().substring(0,stbZong.toString().length()-1));
        }
    }
}

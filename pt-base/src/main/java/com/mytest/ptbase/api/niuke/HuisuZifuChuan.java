package com.mytest.ptbase.api.niuke;

import java.util.*;

public class HuisuZifuChuan {
        public List<String> letterCombinations(String digits) {
            List<String> solutions=new ArrayList<>();
            HashMap<Character,String> map=new HashMap<>();
            map.put('2',"abc");
            map.put('3',"def");
            map.put('4',"ghi");
            map.put('5',"jkl");
            map.put('6',"mno");
            map.put('7',"pqrs");
            map.put('8',"tuv");
            map.put('9',"wxyz");
            if(digits.equals("")){return solutions;}
            backTrack(solutions,map,digits,0,new StringBuilder());
            return solutions;
        }

        public static void backTrack(List<String> solutions,HashMap<Character,String> map,String digits,int row,StringBuilder stb){
            int n=digits.length();
            if(row==n){
                solutions.add(stb.toString());
            }else{
                for(int col=0;col<map.get(digits.charAt(row)).length();col++)
                {
                    stb.append(map.get(digits.charAt(row)).charAt(col));
                    backTrack(solutions,map,digits,row+1,stb);
                    stb.deleteCharAt(row);
                }
            }

        }
}

package com.mytest.ptbase.api.niuke;
import java.util.*;

public class NQueens {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> solutions=new ArrayList<>();
            // List<String> plan=new ArrayList<>();
            int[] queen=new int[n];
            backTrack(solutions,queen,0,n);
            return solutions;
        }

        public static void backTrack(List<List<String>> solutions,int[] queen,int row,int n){
            if(row==n){
                solutions.add(generatePlan(queen,n));
            }else{
                for(int col=0;col<n;col++){
                    if(isActive(queen,col,row)){
                        queen[row]=col;
                        backTrack(solutions,queen,row+1,n);
                        queen[row]=-1;
                    }
                }
            }
        }

        public static boolean isActive(int[] queen,int col,int row){
            for(int i=0;i<row;i++){
                if(col==queen[i]||Math.abs(row-i)==Math.abs(col-queen[i])){
                    return false;
                }
            }
            return true;
        }

        public static List<String> generatePlan(int[] queen,int n){
            List<String> plan=new ArrayList<>();
            for(int i=0;i<n;i++){
                char[] charzu=new char[n];
                for(int j=0;j<n;j++){
                    charzu[j]='.';
                }
                charzu[queen[i]]='Q';
                String s=new String(charzu);
                plan.add(s);
            }
            return plan;

        }

        // public static void main(String[] args) {
        //     List<List<String>> solutions=new ArrayList<>();
        //     Solution solu=new Solution();
        //     solutions=solu.solveNQueens(4);
        //     for (List<String> solution : solutions) {
        //         for (String row : solution) {
        //             System.out.println(row);
        //         }
        //         System.out.println();
        //     }
        // }

}

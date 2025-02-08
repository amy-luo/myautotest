package com.mytest.ptbase.api.niuke;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

//栈数据合并，Stack的操作，push压栈，pop弹出顶部元素，
public class ZhanShuJuHeBING {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Integer> stack=new Stack<>();//存放数据栈
        Stack<Integer> rStack=new Stack<>();//存放删除的元素，不一定要删除，先存放着；
        String[] s=in.nextLine().split(" ");
        for(int i=0;i<s.length;i++){
            int o=Integer.valueOf(s[i]);//当前元素
            rStack.push(o);//将当前元素放入删除栈，假设往前推能跟其他元素合并。
            int sum=0;
            while(!stack.isEmpty()){
                int po=stack.pop();
                sum=sum+po;//弹出顶部元素
//                System.out.println(sum);
                rStack.push(po);//存入删除栈
                if(o==sum){
                    stack.push(2*o);
                    rStack.removeAllElements();
                }
            }
            while(!rStack.isEmpty()) {
                stack.push(rStack.pop());
            }
        }
        StringBuilder stb=new StringBuilder();
        while(!stack.isEmpty()){
            stb.append(stack.pop());
            stb.append(" ");
        }
        System.out.println(stb.toString());
        }

}

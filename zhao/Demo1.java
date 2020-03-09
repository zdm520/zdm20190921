package com.java.demo;

import java.util.LinkedList;
import java.util.Queue;

/**
 *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 */
public class Demo1 {
    public static void main(String[] args) {
        String str="acdhgdglakweugabak";
        Demo1 demo1=new Demo1();
        int rs=demo1.lengthOfLongestSubstring(str);
        System.out.println(rs);
    }
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<1){   //看是不是空串
            return 0;
        }
        int max=1; // ，不是空串的话，最少会有一个，定义为最大的
        for(int head=0, tail=1;tail<s.length();tail++){
            //定义tail为字符串第二个位置，然后依次朝后面走，
            char c=s.charAt(tail);//得到第一个字符
            int index=s.indexOf(c,head);//从head开始查找c的位置
            if(index<tail){
                head+=(index-head+1); //如果得到的位置小于tail,则说明一定有重复的了
                //新的头就到(index-head+1)+head这，这里就是和tail位置重复的字符的下一个位置
            }
            int len=tail-head+1; //得到的就是从index位置的下一个位置到tail的距离，也就是
            //新的不重复的距离
            max=len>max?len:max;  //和前面的比较，取最大
        }
        return max;
    }
}
package offer;

import java.util.*;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c
 * 所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。v
 */

public class TestString {
    public static void main(String[] args) {
        java.lang.String str="abc";
        ArrayList<String> rs=permutation(str);
        System.out.println(rs);
    }
    public static ArrayList<String> permutation(String str){
        ArrayList<String> list=new ArrayList<>();
        if(str==null){
            return list;
        }
        char[] c1=str.toCharArray();
        func(c1,0,list);
        Collections.sort(list);
        return list;

    }
    public static void func(char[] chars,int i,ArrayList<String> list){
        if (chars==null){
            return;
        }
        if (i==chars.length-1){
            if(list.contains(String.valueOf(chars))){
                return;
            }
            list.add(String.valueOf(chars));
        }
        else {
            for (int j=i;j<chars.length;j++){
                swap(chars,i,j);
                func(chars,i+1,list);
                swap(chars,j,i);
            }
        }
    }

    public static void swap(char[] arr,int i,int j){
        char tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }

}

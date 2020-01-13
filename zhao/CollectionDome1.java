package com.java.demo;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDome1 {
    public static void main(String[] args) {
        //创建集合对象
        Collection<String> col=new ArrayList<>();
        //添加元素
        col.add("孙尚香");
        col.add("钟无艳");
        col.add("安其拉");
        //打印这个集合数组
        System.out.println(col);
        //判断集合里面是否包含孙尚香
        System.out.println(col.contains("孙尚香"));
        //删除安其拉
        System.out.println(col.remove("安其拉"));
        //显示删除之后的集合中的元素
        System.out.println(col);
        //看集合中有几个元素
        System.out.println(col.size());
        Object[] arr=col.toArray();
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        col.clear();
        System.out.println("集合的内容为:"+col);
        System.out.println(col.isEmpty());
    }
}

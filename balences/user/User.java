package com.zhao.user;

import com.zhao.book.BookList;
import com.zhao.operation.IOperation;

/**
 * 将User设置为抽象类，里面有抽象方法和自己的方法
 * 继承的类将继承这些属性和方法
 */

public abstract class User {
    protected String name;
    protected IOperation[]operations;
    public abstract int menu();
    public void doOperation(int choice, BookList bookList){
        operations[choice].work(bookList);     //接口数组对象是一些实现了这个接口类的实例，
        // 然后调用接口的方法（因为这些类实现了这个接口，重写了接口里面的方法），实现一种功能
    }
}

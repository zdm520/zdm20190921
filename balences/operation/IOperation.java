package com.zhao.operation;

import com.zhao.book.BookList;

import java.util.Scanner;

/**
 * 设置一个接口，里面有一个抽象方法，因为都是对BookList操作的
 * 所以方法的参数为BookList类型的
 */

public interface IOperation {
    public abstract void work(BookList bookList);
    Scanner scanner=new Scanner(System.in);
}

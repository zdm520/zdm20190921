package com.zhao.operation;

import com.zhao.book.BookList;

public class EixtOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("退出");
        System.exit(0);
    }
}

package com.zhao.operation;

import com.zhao.book.BookList;

/**
 * 打印书籍名单
 */

public class DisplayOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("打印的书籍");
        for(int i=0;i<bookList.getSize();i++){
            System.out.println(bookList.getBook(i).toString());
        }
    }
}

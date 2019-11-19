package com.zhao.operation;

import com.zhao.book.Book;
import com.zhao.book.BookList;

public class ReturnOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入要归还的图书的名称");
        String name=scanner.next();
        int i=0;
        for(i=0;i<bookList.getSize();i++){
            if(bookList.getBook(i).name.equals(name)){
                break;
            }
            if(i>bookList.getSize()){
                System.out.println("没有此书");
            }
        }
        Book book=bookList.getBook(i);
        if(book.isBorrowed){
            book.isBorrowed=false;
            System.out.println("书籍归还成功");
        }
        else {
            System.out.println("书籍归还失败");
        }
    }
}

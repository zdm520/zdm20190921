package com.zhao.operation;

import com.zhao.book.Book;
import com.zhao.book.BookList;

public class DelOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("输入需要删除书籍的名称");
        String name=scanner.next();
        int i=0;
        if(i>bookList.getSize()){
            System.out.println("查找的书籍不存在");
        }
        for(i=0;i<bookList.getSize();i++){
            if(bookList.getBook(i).name==name){
                Book bookNext=bookList.getBook(i+1);
                bookList.setBooks(i,bookNext);
            }
            bookList.setSize(bookList.getSize()-1);
            System.out.println("删除书籍成功");
        }
    }
}




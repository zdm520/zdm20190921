package com.zhao.operation;

import com.zhao.book.Book;
import com.zhao.book.BookList;

public class BorrowOperatioin implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("BorrowOperation");
        System.out.println("输入需要借阅书籍的名称");
        String name=scanner.next();
        int i=0;
        for(i=0;i<bookList.getSize();i++){
           if(bookList.getBook(i).name.equals(name)){
               break;
           }
        }
        if(i>bookList.getSize()){
            System.out.println("没有此书");
            return;
        }
        Book book=bookList.getBook(i);
        if(book.isBorrowed==true){
            System.out.println("已经被借了");
        }
        else{
            book.isBorrowed=true;
            System.out.println("借阅成功");
        }
    }

}

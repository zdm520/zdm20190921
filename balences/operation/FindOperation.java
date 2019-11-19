package com.zhao.operation;

import com.zhao.book.BookList;

public class FindOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入需要查找书籍的名称");
        String name=scanner.next();
        int i=0;
        for(i=0;i<bookList.getSize();i++){
            if(bookList.getBook(i).name.equals(name)){
                break;
            }
            if(i>bookList.getSize()){
                System.out.println("查找的书籍不存在");
            }
        }
        System.out.println("书籍查找成功");
    }
}

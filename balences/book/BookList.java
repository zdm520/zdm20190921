package com.zhao.book;

/**
 *创建书的对象以及书的位置信息
 *
 */

public class BookList {
    public Book[]books=new Book[] {new Book("三国演义","罗贯中",15,"小说"),
                                   new Book("西游记","吴承恩",20,"小说"),
                                   new Book("红楼梦","曹雪芹",21,"小说")};
    public int size;//有效数据个数
    public BookList(){
        this.size=3;
    }
    //在pos位置放着书
    public void setBooks(int pos,Book book){
        this.books[pos]=book;
    }
    public Book getBook(int pos){
        return books[pos];
    }
    public int getSize(){
        return size;
    }
    public void setSize(int size){
        this.size=size;
    }
}

package com.java.zhao;

public class Test {
    public static void drawShape(Shape shape){
        shape.draw();
    }
    public static void main(String[] args) {
        Shape shape1=new Cycle();
        Shape shape2=new Rect();
        Shape shape3=new Flower();
        drawShape(shape1);
        drawShape(shape2);
        drawShape(shape3);
    }
}
class Shape{
    public void draw(){

    }
}
class Cycle extends Shape{
    @Override
    public void draw() {
        super.draw();
        System.out.println("画圆圈");
    }
}
class Rect extends Shape{
    @Override
    public void draw() {
        super.draw();
        System.out.println("画方块");
    }
}
class Flower extends Shape{
    @Override
    public void draw() {
        super.draw();
        System.out.println("画小花");
    }
}
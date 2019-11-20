package com.zhao.student;

public class Student implements Comparable {
     private String name;
     private int age;
     private int score;

     public Student(String name,int age,int score){
         this.age=age;
         this.name=name;
         this.score=score;
     }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
    @Override
    public int compareTo(Object o) {
        Student s=(Student)o;
        return this.score-s.score;
    }
}

package com.zhao.student;

        import java.util.Arrays;

public class TestStudent {
    public static void main(String[] args) {
        Student[]students=new Student[]{
                new Student("马泽",22,95),
                new Student("赵代猛",18,99),
                new Student("陈云浩",20,97),
        };
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}

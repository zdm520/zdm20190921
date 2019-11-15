package coms.sofency.test;

public class TestWork9 {
    public static void swap(TestWork10 a,TestWork10 b){
        TestWork10 tmp=new TestWork10();
        tmp.num1=a.num1;
        a.num1=b.num1;
        b.num1=tmp.num1;
    }
    public static void main(String[] args) {
        TestWork10 work1=new TestWork10();
        TestWork10 work2=new TestWork10();
        work1.num1=10;
        work2.num1=20;
        swap(work1,work2);
        System.out.println(work1.num1);
        System.out.println(work2.num1);
    }
}
class TestWork10{
    public int num1;
}


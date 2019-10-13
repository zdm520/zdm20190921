package AK.homeWork;

public class testx {
	public static void swap(test a,test b) {
		test tmp=new test();
		tmp.abc=a.abc;
		a.abc=b.abc;
		b.abc=tmp.abc;
	}
	public static void main(String[] args) {
		test a1=new test();
		test b1=new test();
		a1.abc=10;
		b1.abc=20;
		System.out.println("q:"+a1.abc+"\t"+b1.abc);
		swap(a1,b1);
		System.out.println("q:"+a1.abc+"\t"+b1.abc);
	}
}

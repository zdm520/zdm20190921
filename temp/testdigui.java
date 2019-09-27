package myproject;

public class testdigui {
	static int didui(int n) {
		if(n==1) {
			return 1;
		}
		else {
			return n*didui(n-1); 
		}
	}
	public static void main(String[] args) {
		System.out.println(didui(5));
	}
}
	
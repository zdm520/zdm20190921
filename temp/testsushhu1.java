package cn.code;

public class testsushhu1 {
	public static void main(String[] args) {
		int i=0;
		int j=-0;
		for( i=2;i<=100;i++) {
			for( j=2;j<i;j++) {
				if(i%j==0) {
					break;
				}
			}
			if(j>=i) {
				System.out.println(i+"是素数");
		}
	}

	}
}
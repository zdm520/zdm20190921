package internet;

import java.util.Scanner;

public class CreateName {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			String string = in.nextLine();
			String rs = fun(string);
			System.out.println(rs);
		}
	}
	public static String fun(String str) {
		String[] strings = str.split("_");
		String str1 = "";
		str1+=strings[0];
		for(int i=1;i<strings.length;i++) {
			String rsString = strings[i].substring(0,1).toUpperCase()+strings[i].substring(1);
			str1+=rsString;
		}
		return str1;
	}
}

package lesson1;

import java.util.Scanner;

public class DemoString2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str1=sc.nextLine();
        String str2=sc.nextLine();
        DemoString2 d=new DemoString2();
        int rs=d.function(str1,str2);
        System.out.println(rs);
    }
    public int function(String str1,String str2){
        int count=0;
        String str3=null;
        String str4=null;
        if(str1.length()==0){
            StringBuffer sb2=new StringBuffer(str2);
            sb2.reverse();
            String string=new String(sb2);
            if(str2.equals(string)){
                return 1;
            }else {
                return 0;
            }
        }
        if(str2.length()==0){
            return str1.length();
        }
        for(int i=0;i<str1.length();i++){
            StringBuffer sb=new StringBuffer(str1);
            StringBuffer sb1=new StringBuffer();
            sb.insert(i,str2);
            str3=new String(sb);
            sb1.append(str3);
            sb1.reverse();
            str4=new String(sb1);
            if(str3.equals(str4)){
                count++;
            }
            sb.delete(0,sb.length());
        }
        return count;
    }
}

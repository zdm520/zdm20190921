package worker;

import java.util.Scanner;

public class Day9 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s1=sc.nextLine();
            String s2=sc.nextLine();
            String rs=addLongInteger(s1,s2);
            System.out.println(rs);
        }
    }
    public static String addLongInteger(String s1,String s2){
        if(s1!=null || s2!=null ){
            StringBuffer sb=new StringBuffer();
            int length1=s1.length();
            int length2=s2.length();
            int index1=length1-1;
            int index2=length2-1;
            int count=0;
            while(index1>=0 && index2>=0){
                int c1=Character.getNumericValue(s1.charAt(index1));
                int c2=Character.getNumericValue(s2.charAt(index2));
                int c=c1+c2;
                if(c>=0 && c<=9){
                    sb.append(c+count);
                    count=0;
                }else {
                    count=c/10;
                    sb.append(c%10);
                }
                index1--;
                index2--;
            }
            int number=0;
            while (index1>=0){
                 if (count!=0){
                    number=Character.getNumericValue(s1.charAt(index1))+count;
                    sb.append(number%10);
                    count=number/10;
                    index1--;
                }else {
                    sb.append(Character.getNumericValue(s1.charAt(index1)));
                    index1--;
                }
            }

            while (index2>=0){
                if (count!=0){
                    number=Character.getNumericValue(s2.charAt(index2))+count;
                    sb.append(number%10);
                    count=number/10;
                    index2--;
                }else {
                   sb.append(Character.getNumericValue(s2.charAt(index2)));
                   index2--;
                }
            }
            if(number/10!=0){
                sb.append(number/10);
            }
            sb.reverse();
            String str=new String(sb);
            return str;
        }
        return null;
    }
}

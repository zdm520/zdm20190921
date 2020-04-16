package offer;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class BadKey {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            String all=sc.nextLine().toUpperCase();
            String right=sc.nextLine().toUpperCase();
            Set<Character> s=new HashSet<>();
            for(int i=0;i<right.length();i++){
                char c=right.charAt(i);
                s.add(c);
            }
            for(int i=0;i<all.length();i++){
                char c1=all.charAt(i);
                if(!s.contains(c1)){
                    s.add(c1);
                    System.out.print(c1);
                }
            }
            System.out.println();
        }
    }
}

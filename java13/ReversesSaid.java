package offer;

import java.util.Scanner;

public class ReversesSaid {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            String[] strings = str.split(" ");
            for(int i=strings.length-1;i>=0;i--){
                System.out.print(strings[i]+" ");
            }
        }
    }
}

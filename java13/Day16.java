package offer;
/**
 * 改里面将数字和字母统一看成是char类型的，所以数字3实际存储时为ASCII码中的‘3’，
 * 其十进制表示是51，转化为
 * 二进制表示就是0110011，取最高位为奇校验位，校验位为1，
 * 所以校验后的二进制数为10110011，字母同理。
 * 故本题只需将输入的字符减去‘\0’得到字符的十进制表示，
 * 再将其转化为七位二进制数加上一位校验位输出即可
 *
 */



import java.util.Scanner;

public class Day16 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            func(str);
        }
    }

    public static void func(String str){
        char[] chars = str.toCharArray();
        int[] res = new int[8];
        for(char x : chars){
            int n=1;
            int j=7;
            int count=0;
            while (j>0){
                res[j]=(x&n)==0 ? 0 : 1;
                if(res[j]==1){
                    count++;
                }
                n=n<<1;
                j--;
            }
            if((count&1)==0){
                res[0]=1;
            }
            for(int i=0;i<res.length;i++){
                System.out.print(res[i]);
            }
            res[0]=0;
            System.out.println();
        }

    }
}

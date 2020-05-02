package worker;

import java.util.Scanner;

/**
 * 密码验证合格程序
 *
 */

public class Day15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str=in.next();
            String rs=function(str);
            System.out.println(rs);
        }
    }
    public static String function(String str){
        if(str.length()<=8){
            return "NG";
        }
        if(judge(str)<3){
            return "NG";
        }
        if(catchTwo(str)==false){
            return "NG";
        }
        return "OK";
    }
    //判断字符串大小写，数字，其他符号，以上四种至少三种
    public static int judge(String str){
        int daxie=0,xiaoxie=0,other=0,number=0;
        for (Character e : str.toCharArray()){
            if(Character.isUpperCase(e)){
                daxie=1;
            }
            else if(Character.isLowerCase(e)){
                xiaoxie=1;
            }
            else if(Character.isDigit(e)){
                number=1;
            }else {
                other=1;
            }
        }
        int count=other+daxie+xiaoxie+number;
        return count;
    }
    //判断相同长度是否超过2
    public static boolean catchTwo(String str){
        if(str==null){
            return false;
        }
        for(int i=0;i<str.length()-3;i++){
            String str1=str.substring(i,i+3);
            String str2=str.substring(i+3,str.length());
            if(str2.contains(str1)){
                return false;
            }
        }
        return true;
    }


}

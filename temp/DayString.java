package worker;

/**
 *
 * 从第一个字符串中删除第二个字符串中所有的字符
 * 拼接法删除
 */

public class DayString {
    public static void main(String[] args) {
        String str1="They are students";
        String str2="aeiou";
        DayString d=new DayString();
        d.delete(str1,str2);
    }
    public void delete(String str1,String str2){
        if(str1==null || str2==null){
            System.out.println(str1);
        }
        else {
            for (int i=0;i<str2.length();i++){
                int index=0;
                while ((index=str1.indexOf(str2.charAt(i)))!=-1){
                    str1=str1.substring(0,index)+str1.substring(index+1);
                }
            }
            System.out.println(str1);
        }
    }
}

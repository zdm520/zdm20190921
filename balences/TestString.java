package coms.sofency;

/**
 * 字符串的逆置
 */
public class TestString {
    public static String[] func(String[]strings){
        int left=0;
        int right=strings.length-1;
       while(left<right){
         String tmp=strings[left];
         strings[left]=strings[right];
         strings[right]=tmp;
         left++;
         right--;
       }
        return strings;
    }
    public static void display(String[]strings){
        for(int i=0;i<strings.length;i++){
            System.out.print(strings[i]+" ");
        }
    }
    public static void main(String[] args) {
        String string="i am student";
        String[] strings=(string.split(" "));//使用split方法使字符串变为
        String[]strings1=func(strings);
        display(strings1);

    }
}

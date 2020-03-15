
//请实现一个函数，将一个字符串中的每个空格替换成“%20”

public class Solution {
    public String replaceSpace(StringBuffer str) {
        StringBuffer sb=new StringBuffer();
    	for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                sb.append("%20");
            }else{
                sb.append(str.charAt(i));
            }
        }
        String str1=new String(sb);
        return str1;
    }
}
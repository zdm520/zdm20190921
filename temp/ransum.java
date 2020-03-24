//赎金信

//给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
//判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以
//构成，返回 true ；否则返回 false。

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        StringBuffer sb=new StringBuffer(magazine);
        int index;
        for(char c:ransomNote.toCharArray()){
            index=sb.indexOf(String.valueOf(c));
            if(index>=0){
                sb.deleteCharAt(index);
            }else{
                return false;
            }
        }
        return true;
    }
}
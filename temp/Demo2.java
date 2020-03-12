
//回文数整数
class Solution {
    public boolean isPalindrome(int x) {
        int rs=x;
        if(rs<0){
            return false;
        }
        int k=0;
        while(rs>0){
            k=rs%10+k*10;
            rs=rs/10;
        }
        return (k==x)?true:false;
    }
}
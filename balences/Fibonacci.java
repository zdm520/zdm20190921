
//输入一个整数n，请你输出斐波那契数列的第n项

public class Solution {
    public int Fibonacci(int n) {
        if(n<0 || n>39){
            return -1;
        }
        if(n==0){
            return 0;
        }
        if(n==1 || n==2){
            return 1;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
}



//跳台阶问题简单的

public class Solution {
    public int JumpFloor(int target) {
        if(target<=0){
            return 0;
        }
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        return JumpFloor(target-1)+JumpFloor(target-2);
    }
}
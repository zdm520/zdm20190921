//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
//如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。


import java.util.Stack;

public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null || sequence.length==0){
            return false;
        }
        Stack<Integer> stack1=new Stack<>();
        int len=sequence.length-1;
        int j=0;
        //如果j<len进入
        if(j<=len){
            //如果第一个数小于最后一个进入，最后一个就是根
            while(sequence[j]<sequence[len]){
                if(sequence[j]==sequence[len]){
                    return false;
                }
                stack1.push(sequence[j]);
                j++;
            }
            //如果第一个大于最后一个数或者退出了前面的，满足了这个大于最后一个进入
            while(j<len && sequence[j]>sequence[len]){
                stack1.push(sequence[j]);
                j++;
            }
            //再把最后一个根放进栈
            stack1.push(sequence[len]);
        }
        //如果数组长度等于栈的元素个数，则是true
        return stack1.size()== sequence.length;
    }
}
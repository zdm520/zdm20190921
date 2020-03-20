
//定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。

import java.util.Stack;

public class Solution {
     Stack<Integer> stack=new Stack<>();
    Stack<Integer> stack2=new Stack<>();
    public void push(int node) {
       stack.push(node);
    }
    
    public void pop() {
       stack.pop();
    }
    
    public int top() {
        if(!stack.isEmpty()){
            return stack.peek();
        }
        return -1;
    }
    
    public int min() {
        int min=Integer.MAX_VALUE;
        while(!stack.isEmpty()){
            int pop=stack.pop();
            if(min>pop){
                min=pop;
            }
            stack2.push(pop);
        }
       while(!stack2.isEmpty()){
           stack.push(stack2.pop());
       }
        return min;
    }
}

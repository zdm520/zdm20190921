import java.util.Stack;
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
       Stack<ListNode> stack=new Stack();
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(listNode==null){
            return list;
        }
        while(listNode!=null){
            stack.push(listNode);
                listNode=listNode.next;
        }
        while(!stack.isEmpty()){
            ListNode node=stack.pop();
            list.add(node.val);
        }
        return list;
    }
}
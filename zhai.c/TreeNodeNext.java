/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
//找二叉树的下一节点


import java.util.List;
import java.util.ArrayList;
public class Solution {
    List<TreeLinkNode> list = new ArrayList<>();
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null){
            return null;
        }
        TreeLinkNode cur = pNode;
        while(cur.next!=null){
            cur = cur.next;
        }
        seek(cur);
        for(int i=0;i<list.size();i++){
            if(pNode == list.get(i)){
                return i==list.size()-1?null:list.get(i+1);
            }
        }
        return null;
    }
    public void seek(TreeLinkNode node){
        if(node!=null){
            seek(node.left);
            list.add(node);
            seek(node.right);
        }
    }
}
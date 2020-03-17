
//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null || q==null){
            return null;
        }
        Stack<TreeNode> p1=new Stack<>();
        Stack<TreeNode> q1=new Stack<>();
        findPath(root,p,p1);
        findPath(root,q,q1);
        int psize=p1.size();
        int qsize=q1.size();
        while(psize!=0 && qsize!=0){
            if(psize>qsize){
                p1.pop();
                psize--;
            }
        else if(qsize>psize){
            q1.pop();
            qsize--;
        }else{
            if(p1.peek()==q1.peek()){
                return p1.peek();
            }
            p1.pop();
            q1.pop();
            psize--;
            qsize--;
            }
        }
        return null;

    }

    public boolean findPath(TreeNode root, TreeNode node, Stack<TreeNode> path){
        if(root==null){
            return false;
        }
        path.push(root);
        if(root==node){
            return true;
        }
        if(findPath(root.left,node,path)||findPath(root.right,node,path)){
            return true;
        }
        path.pop();
        return false;
    }
}
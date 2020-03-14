//非递归中序遍历

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur=root;
        while(!stack.isEmpty() || cur!=null){
           if(cur!=null){
               stack.push(cur);
               cur=cur.left;
           }else{
               cur=stack.pop();
               list.add(cur.val);
               cur=cur.right;
           }
        }
        return list;
    }
}
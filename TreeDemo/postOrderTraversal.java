//非递归后序遍历

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        TreeNode cur=root;
        TreeNode node1=null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(!stack.isEmpty() || cur!=null){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode top=stack.peek();
            if(top.right==null || top.right==node1){
                TreeNode node=stack.pop();
                node1=node;
                list.add(node.val);
            }
            else{
                cur=top.right;
            }
        }
        return list;

    }
}
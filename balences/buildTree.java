//根据一棵树的前序遍历与中序遍历构造二叉树。
//例如，给出

//前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode node=creatTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        return node;
    }

    public TreeNode creatTree(int[]preorder,int Prestart,int Preend,int[]inorder,int Inostart,int Inoend){
        if(Prestart>Preend || Inostart>Inoend){
            return null;
        }
        TreeNode root=new TreeNode(preorder[Prestart]);
        for(int i=Inostart;i<=Inoend;i++){
            if(preorder[Prestart]==inorder[i]){
                root.left=creatTree(preorder,Prestart+1,Prestart+i-Inostart,inorder,Inostart,i-1);
                root.right=creatTree(preorder,Prestart+i-Inostart+1,Preend,inorder,i+1,Inoend);
                break;
            }
        }
        return root;
    }

}
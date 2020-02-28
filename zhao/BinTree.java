package com.java.demo;

/**
 * 二叉树使用递归思想求解
 */


class BTNode{
    BTNode left=null;//指向该节点的左孩子
    BTNode right=null;
    int val;

    public BTNode(int val){
        this.val=val;
    }
}


public class BinTree {
    private BTNode root=null;//引用二叉树的根节点

    //前序遍历
    public void preOrder(BTNode root){
        if(root!=null){
            System.out.println(root+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //求二叉树节点的个数，左子树数加右子树数加根节点数
    private int getCount(BTNode root){
        if(root==null){
            return 0;
        }
        return getCount(root.left)+getCount(root.right)+1;
    }

    //求二叉树的叶子结点数
    private int getLeafNodeCount(BTNode root){
        if(root==null){
            return 0;
        }

        if(root.right==null || root.left==null){
            return 1;
        }

        return getLeafNodeCount(root.left)+getLeafNodeCount(root.right);
    }

}

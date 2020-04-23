package offer;

public class SearchTree {
    public static class Node{
        private Node left;
        private Node right;
        int val;
        public Node(int val){
            this.val=val;
        }
    }
    public Node root=null;

    //插入，要知道待插入节点的父节点
    public boolean put(int val){
        if(root==null){
            throw new IllegalArgumentException();
        }
        Node cur = root;
        Node parent=null;
        while(cur!=null){
            parent=cur;
            if(cur.val==val){
                return false;
            }else if (cur.val>val){
                cur=cur.left;
            }else {
                cur=cur.right;
            }
        }
        //要插入的节点
        cur=new Node(val);
        if(parent.val>val){
            parent.left=cur;
        }
        else {
            parent.right=cur;
        }
        return true;
    }

    //是否包含给定值
    public boolean contains(int val){
        if(root==null){
            throw new IllegalArgumentException();
        }
        Node cur=root;
        while (cur!=null){
            if (cur.val==val){
                return true;
            }else if (cur.val>val){
                cur=cur.left;
            }else {
                cur=cur.right;
            }
        }
        return false;
    }


    public boolean remove(int val){
        //如果root为空
        if(null==root){
            throw new IllegalArgumentException();
        }
        //遍历搜索树，找到与val值相等的节点结束循环
        //用一个节点保存待删除节点的父节点
        Node cur=root;
        Node parent=null;
        while (cur!=null){
            if(val>cur.val){
                parent=cur;
                cur=cur.right;
            }else if (val<cur.val){
                parent=cur;
                cur=cur.left;
            }else {
                break;
            }
        }
        if(cur==null){
            return false;
        }
        //已经找到待删除节点，现在分情况
        //1：cur只有左孩子
        if(cur.right==null){
            //只有左孩子并且cur为头结点
            if(parent==null){
                root=cur.left;
                return true;
            }else {
                //只有左孩子cur不是头结点
                parent.left=cur.left;
                return true;
            }
        }
        //2：cur只有右孩子
        if(cur.left==null){
            //只有右孩子并且cur为头结点
            if(parent==null){
                root=cur.right;
                return true;
            }else {
                //只有右孩子cur不是头结点
                parent.right=cur.right;
                return true;
            }
        }
        //3：cur左右孩子均存在
        //不能直接删除，在它的子树中找一个替代节点
        //左子树：找左子树中最大的节点（最右侧节点）
        //右子树：找右子树中最小的节点（最左侧节点）
        Node del=cur.right;
        parent=cur;
        while (del.left!=null){
            parent=del;
            del=del.left;
        }
        //替代节点找到
        cur.val=del.val;
        //删除这个节点，相当于替代节点到了cur的位置
        //再把最下面的替代节点删掉，转换思维，就是删掉了cur
        if(del==parent.left){
            parent.left=del.right;
            return true;
        }else {
            parent.right=del.right;
            return true;
        }
    }


    Node pre=null;
    public Node doublelinklist(){
        if(null==root){
            return null;
        }
        //找树中最左侧的节点，即双向链表的头
        Node head=root;
        while (head.left!=null){
            head=head.left;
        }
        //修改每个节点left和right的指向
        doublelinklist(root);
        return head;
    }


    public void doublelinklist(Node root){
        if(root==null){
            return;
        }
        //转化根节点的左子树
        doublelinklist(root.left);

        //转化根节点
        root.left=pre;
        if(pre!=null){
            pre.right=root;
        }
        pre=root;
        //转化根节点的右子树
        doublelinklist(root.right);
    }


    public static void main(String[] args) {
        int[] arr={5,3,4,1,7,8,2,6,0,9};
        SearchTree t=new SearchTree();
        for (int e : arr){
            t.put(e);
        }

    }
}

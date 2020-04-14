
//使用HashMap求解复杂链表的深拷贝问题，个人感觉这样做很爽

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
//创建一个Map对象	
        Map<Node,Node> m = new HashMap<>();
        Node node=head;
        while(node!=null){
//将原链表的节点作为Key，新new出来的节点里面放的是原链表节点的值作为Value，形成键值对
            m.put(node,new Node(node.val));
            node=node.next;
        }
        node=head;
//分别利用Map的映射关系求出新节点的next指向和Random指向
        while(node!=null){
            m.get(node).next=m.get(node.next);
            m.get(node).random=m.get(node.random);
            node=node.next;
        }
//一样利用映射关系返回头结点
        return m.get(head);
    }
}
package lesson5;

/**
 * 哈希桶---数组+链表实现
 * 数组：帮助用户快速定位要将元素插入到哪个链表，组织链表
 * 数组中存储的元素为节点的引用
 *假设哈希桶中的key唯一
 */

public class HashBucket {
    public static class Node{
        int key;
        int value;
        Node next;
        Node(int key,int value){
            this.key=key;
            this.value=value;
            next=null;
        }
    }
    //哈希桶中的成员数据
    Node[] table;
    int capacity;//桶的个数
    int size;  //有效元素个数
    double loadfact=0.75;
    public HashBucket(int initCap){
        //保证哈希桶初始容量为10个
        if(initCap<10){
            capacity=10;
        }
        table=new Node[capacity];
        size=0;
    }

    //增加元素
    public int put(int key,int value){
        //通过哈希函数计算出桶号
        int bucketNo=hashFunc(key);
        //在这个桶里面遍历链表，看key是否存在
        Node cur=table[bucketNo];
        while (cur!=null){
            if(cur.key==key){
                int oldvalue=cur.value;
                cur.value=value;
                return oldvalue;
            }
            cur=cur.next;
        }
        //key为空
        cur=new Node(key,value);
        cur.next=table[bucketNo];
        table[bucketNo]=cur;
        size++;
        return value;
    }

    //删除元素
    public boolean remove(int key){
        //1:找到数组下标
        int bucketId=hashFunc(key);
        //2:得到链表头结点
        Node cur=table[bucketId];
        //遍历链表删除节点,要删除得有一个前驱
        Node pre=null;
        while (cur!=null){
            //找到了要删除的节点
            if(cur.key==key){
                //如果要删除的节点是头结点
                if(pre==null){
                    //将头结点移向要删除节点的下一个节点
                    table[bucketId]=cur.next;
                }
                else {//要删除的节点不是头结点
                    pre.next=cur.next;
                }
                size--;
                return true;
            }
            else {
                pre=cur;
                cur=cur.next;
            }
        }
        return false;
    }

    boolean containsKey(int key){
        //1：获取表的下标
        int bucketId=hashFunc(key);
        //2:获取链表的头
        Node cur=table[bucketId];
        //遍历链表看是否存在key
        while (cur!=null){
            if(cur.key==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

    boolean containsValue(int value){
        //下标是根据key来计算的，因此现在要遍历所有的下标
        for(int bucketNo=0;bucketNo<size;bucketNo++){
            Node cue=table[bucketNo];
            while (cue!=null){
                if(cue.value==value){
                    return true;
                }
                cue=cue.next;
            }
        }
        return false;
    }


    public int size(){
        return size;
    }


    public boolean empty(){
        return size==0;
    }

    private void resize(){
        if(size*10/capacity>loadfact){
            int newCap=capacity*2;
            Node[] newTable=new Node[newCap];
            //将table中的节点搬移到newTable中
            for (int i=0;i<capacity;i++){
                Node cur=table[i];
                while (cur!=null){
                    table[i]=cur.next;//让table[i]放在cur.next处，意味着将cur
                    //这一点拿出来了，然后准备插入到新表中
                    //计算新表的下标
                    int bucketNo=cur.key%newCap;
                    //相当于头插
                    cur.next=newTable[bucketNo];
                    newTable[bucketNo]=cur;
                    //取table中的i号下标的下一个节点
                    cur=table[i];
                }
            }
            table=newTable;
            capacity=newCap;
        }
    }

    private int hashFunc(int key){
        return key%capacity;
    }

    public void print(){
        for(int bucketId=0;bucketId<capacity;bucketId++){
            System.out.printf("table[%d]--->",bucketId);
            Node cur=table[bucketId];
            while (cur!=null){
                System.out.print("["+cur.key+","+cur.value+"]"+"--->");
                cur=cur.next;
            }
            System.out.println("null");
        }
    }


    public static void main(String[] args) {
        HashBucket ht=new HashBucket(5);
        ht.put(5,5);
        ht.put(1,1);
        ht.put(13,3);
        ht.put(11,6);
        ht.put(6,6);
        ht.put(22,22);
        ht.put(3,33);
        System.out.println(ht.containsKey(3));
        System.out.println(ht.size());
        ht.print();
    }

}

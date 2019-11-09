package comes.zhao.java01;

public class MyDoubleList {
    public ListNode head;
    public ListNode last;

    //无参打印链表
    public void show(){
        ListNode cur=head;
        if(head==null){
            return;
        }
      while (cur!=null){
          System.out.println(cur.data+" ");
          cur=cur.next;
      }
        System.out.println();
    }

    //有参打印链表
    public void show1(ListNode head){
        ListNode cur=head;
        if(head==null){
            return;
        }
        while (cur!=null){
            System.out.println(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }

    //双链表头插法
    public void addFirst1(int data){
        ListNode node=new ListNode(data);
        if(head==null){
            head=node;
            last=node;
        }
        else {
            node.next=head;
            head.pre=node;
            head=node;
        }
    }

    //双链表尾插法
    public void addLast1(int data){
        ListNode node=new ListNode(data);
        if(head==null){
            head=node;
            last=node;
        }
        else{
            last.next=node;
            node.pre=last;
            last=node;
        }
    }

    //求双链表的长度
    public int getLength(){
        ListNode cur=head;
        int count=0;
        if(head==null){
            return -1;
        }
        while (cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }

    //查找index的位置并返回
    private ListNode searchIndex1(int index){
        ListNode cur=this.head;
        if(this.head==null){
            return null;
        }
        if(index<0||index>getLength()){
            return null;
        }
      while (index>0){
            cur=cur.next;
            index--;
      }
      return cur;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
       if(index==0){
           addFirst1(data);
           return;
       }
       if(index==getLength()){
           addLast1(data);
           return;
       }
       ListNode cur=searchIndex1(index);
      if(cur==null){
          return;
      }
      ListNode node=new ListNode(data);
      cur.pre.next=node;
      node.next=cur;
      node.pre=cur.pre;
      cur.pre=node;
    }

    //删除第一次出现关键字为key的节点
    public int remove(int key){
        int oldData=-1;
        ListNode cur=this.head;
        while (cur!=null){
           if(cur.data==key){
               oldData=cur.data;
               if(cur==head){
                   head=head.next;
                   head.pre=null;
               }else {
                   if(cur.next!=null){
                       cur.next.pre=cur.pre;
                       cur.pre.next=cur.next;
                   }
                   else {
                      last=cur.pre;
                   }
                   return oldData;
               }
           }
           cur=cur.next;
        }
        return -1;
    }

    //删除所有关键字为key的节点
    public void removeAllKey(int key){
        ListNode cur=head;
        while (cur!=null){
            if(cur.data==key){
                if(cur==head){
                    head=head.next;
                    head.pre=null;
                }
                else {
                    if(cur.next!=null){
                        cur.next.pre=cur.pre;
                        cur.pre.next=cur.next;
                    }
                    else {
                        last=cur.pre;
                    }
                }
            }
            cur=cur.next;
        }

    }

    //清除双链表
    public void clear1(){
        while (this.head!=null){
            ListNode cur=this.head.next;
            this.head.next=null;
            this.head.pre=null;
            this.head=cur;
        }
        this.last=null;
    }

}

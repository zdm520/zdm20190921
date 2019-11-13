package comes.zhao.java01;

/**
 * 单链表的一些应用
 *  author:zhaodaimeng
 *
 */
class ListNode{
    public int data;
    public ListNode next;
    public ListNode random;
    public ListNode pre;
    public ListNode(int data,ListNode next,ListNode random){
        this.data=data;
        this.next=null;
        this.random=null;
    }
    public ListNode(int data){
        this.data=data;
        this.next=null;
        this.random=null;
    }
}
public class MySingleList {
    public ListNode head;
    public MySingleList(){
        this.head=null;
    }

    //头插法
    public void addFist(int data){
        ListNode node=new ListNode(data);
        if(this.head==null){
            this.head=node;
        }
        else {
        node.next=this.head;
        head=node;
        }
    }

    //尾插法
    public void addLast(int data){
        ListNode node=new ListNode(data);
        ListNode cur=this.head;
        if(this.head==null){
            this.head=node;
        }
        else {
           while (cur.next!=null){
               cur=cur.next;
           }
           cur.next=node;
           node.next=null;
        }
    }

    //查找index-1的位置
    public ListNode searchIndex(int index){
        if(index<0||index>getLength()){
            System.out.println("位置不合法");
        }
        ListNode cur=this.head;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        return cur;
    }

    //求出单链表的长度
    public int getLength(){
        ListNode cur=this.head;
        int count=0;
        if(this.head==null){
            return -1;
        }
        while (cur.next!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }

    //任意位置插入，第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
       ListNode node=new ListNode(data);
       if(index==0){
           addFist(data);
           return true;
       }else {
           ListNode n=searchIndex(index);
           node.next=n.next;
           n.next=node;
       }
       return true;
    }

    //查找关键字是否包含在单链表中
    public boolean contains(int key){
        ListNode cur=this.head;
        if(this.head==null){
            return false;
        }
        while (cur.next!=null){
            if(cur.data==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

     //查找有没有传进的值，有的话，返回它的前一个位置
    public ListNode research(int key){
        ListNode cur=this.head;
        if(this.head==null){
            System.out.println("没有查询的值");
        }
        while (cur.next!=null){
            if(cur.next.data==key){
                return cur;
            }
            cur=cur.next;
        }
        return null;
    }

    //删除第一次给定的关键字key的节点
    public void remove(int key){
        if(this.head==null){
            return;
        }
        if(this.head.data==key){
           this.head=this.head.next;
           return;
        }
        ListNode n=research(key);
        if(n==null){
            return;
        }
        ListNode del=n.next;
        n.next=del.next;
    }

    //删除所有值为key的节点
    public void removeAll(int key){
        ListNode cur=this.head;
        ListNode curNext=cur.next;
        while (curNext!=null){
            if(curNext.data==key){
                cur.next=curNext.next;
                curNext=curNext.next;
            }
            else{
             cur=curNext;
             curNext=curNext.next;
            }
        }
        if(cur.data==key){
            this.head=this.head.next;
        }
    }

    //打印单链表
    public void display(){
        ListNode cur=this.head;
        if(this.head==null){
            System.out.println("单链表为空");
        }
        while (cur!=null){
            System.out.println(cur.data);
            cur=cur.next;
        }
    }

    public void display2(ListNode head){
        ListNode cur=head;
        if(head==null){
            return;
        }
        while (cur!=null){
            System.out.println(cur.data);
            cur=cur.next;
        }
    }

    //反转单链表
    public ListNode reverse(){
        ListNode cur=this.head;
        ListNode pre=null;
        ListNode newHead=null;
        while (cur!=null){
            ListNode curNext=cur.next;
            if(cur.next==null){
               newHead=cur;
            }
            cur.next=pre;
            pre=cur;
            cur=curNext;
        }
        return newHead;
    }

    //用快慢指针求中间节点
    public ListNode middleList(){
        ListNode fast=this.head;
        ListNode slow=this.head;
        if(this.head==null){
            System.out.println("单链表为空");
        }
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    //求倒数第k个节点的位置
    public ListNode FindKthToTail(int k){
        ListNode fast=this.head;
        ListNode slow=this.head;
        if (this.head==null){
            System.out.println("单链表为空");
            return null;
        }
        if(k<0){
            return null;
        }
        while (k-1>0){
            fast=fast.next;
            k--;
        }
        while (fast!=null&&fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }

    //将两个有序链表合为一个新的有序链表并返回
    public ListNode creatCut(ListNode headA,ListNode headB){
        ListNode node=new ListNode(-1);
        ListNode tmp=node;
        while (headA!=null&&headB!=null){
            if(headA.data<headB.data){
                tmp.next=headA;
                headA=headA.next;
                tmp=tmp.next;
            }
            else {
                tmp.next=headB;
                headB=headB.next;
                tmp=tmp.next;
            }
            if(headA!=null){
                tmp.next=headA;
            }
            if(headB!=null){
                tmp.next=headB;
            }
            if(tmp.next!=null){
                tmp.next=null;
            }
        }
       return node.next;
    }

    //编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    public ListNode partition(int x){
        ListNode beforeStart=null;
        ListNode beforeEnd=null;
        ListNode afterStart=null;
        ListNode afterEnd=null;
        ListNode cur=this.head;
        if(this.head==null){
            return null;
        }
        while (cur!=null){
           if(cur.data<x){
               if(beforeStart==null){
                  beforeStart=cur;
                  beforeEnd=beforeStart;
               }
               else {
                   beforeEnd.next=cur;
                   beforeEnd=beforeEnd.next;
               }
           }
           else {
               if(afterStart==null){
                   afterStart=cur;
                   afterEnd=afterStart;
               }
               else {
                   afterEnd.next=cur;
                   afterEnd=afterEnd.next;
               }
           }
           cur=cur.next;
        }
      if(beforeStart==null){
            return afterStart;
      }
        beforeEnd.next=afterStart;
      if(afterStart!=null){
            afterEnd.next=null;
      }
      return beforeStart;
    }

    //删除重复的节点
    public ListNode deleteDuplication(){
        ListNode node=new ListNode(-1);
        ListNode tmp=node;
        ListNode cur=this.head;
        if(this.head==null){
            return null;
        }
        while (cur!=null){
            if(cur.next!=null&&cur.data==cur.next.data){
                while (cur.next!=null&&cur.data==cur.next.data){
                    cur=cur.next;
                }
                cur=cur.next;
            }
            else {
                tmp.next=cur;
                cur=cur.next;
                tmp=tmp.next;
            }
        }
        tmp.next=null;
        return node.next;
    }

    //链表的回文结构
    public boolean chkPalindrome(){
        ListNode fast=this.head;
        ListNode slow=this.head;
        if(this.head==null){
            return false;
        }
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode a=slow.next;
        while (a!=null){
            a.next=slow;
            slow=a;
            a=a.next;
        }
        while (head!=slow){
            if(head.data==slow.data){
                return true;
            }
            head=head.next;
            slow=slow.next;
        }
        return false;
    }

    //编写一个程序，找到两个单链表相交的起始节点。
    public  ListNode  getIntersectionNode(ListNode headA,ListNode headB){
        if(headA==null||headB==null){
            return null;
        }
        int lenA=0;
        int lenB=0;
        ListNode LA=headA;
        ListNode LS=headB;
        while (LA!=null){
            lenA++;
        }
        while (LS!=null){
            lenB++;
        }
        LA=headA;
        LS=headB;
        int len=lenA-lenB;
        if(len<0){
            LA=headB;
            LS=headA;
            len=lenB-lenA;
        }
        while (len>0){
            LA=LA.next;
            len--;
        }
        while (LA!=LS&&LA!=null){
            LA=LA.next;
            LS=LS.next;
        }
        if(LA.next==LS.next&&LA.next!=null){
            return LA.next;
        }
        return null;
    }

    //判断链表中是否有环
    public boolean hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        if(head==null){
            return false;
        }
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }

    //给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        if(head==null){
            return null;
        }
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    //复制带随机指针的链表
    public ListNode copyList(ListNode head){
        ListNode cur=head;
        if(head==null){
            return null;
        }
        // 将新旧链表连接起来
       while (cur!=null){
            ListNode node=new ListNode(cur.data,cur.next,null); //每循环一次，就多一个新的node节点
            ListNode tmp=cur.next;
                cur.next=node;
                cur=tmp;
       }
       cur=head;
        //利用旧链表可以弄出新的链表的randow的指向
       while (cur!=null){
          if(cur.random!=null){             //判断随机指针是否为空
              cur.next.random=cur.random.next;
          }else {
              cur.next.random=null;
          }
           cur=cur.next.next;
       }
       cur=head;
       //让新旧链表断开
        ListNode newHead=cur.next;   //保存将要返回的新链表的头
       while (cur.next!=null){
           ListNode tmp=cur.next;
           cur.next=tmp.next;
           cur=tmp;
       }
       return newHead;
    }

    public void clear(){
        while (this.head!=null){
            ListNode cur=this.head.next;
            this.head.next=null;
            this.head=cur;
        }
    }



}

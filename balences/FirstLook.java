package lesson1;
import java.util.PriorityQueue;
/**
 *优先级队列（堆）
 *
 */
//为了实现简单，假设优先级队列中放置int
public class FirstLook {
    private int[] arr;
    int size=0;
    public FirstLook(){
        arr=new int[11];
    }
    public FirstLook(int Capacity){
        if(Capacity<1){
            Capacity=11;
        }
        arr=new int[Capacity];
    }
    public FirstLook(int[] array){
        arr=new int[array.length];
        for(int i=0;i<array.length;i++){
            arr[i]=array[i];
        }
        size=arr.length;
        int lastLeaf=(arr.length-2)>>1;
        //找到倒数第一个非叶子节点，一直向下调整就可以创建堆
        for(int root=lastLeaf;root>=0;root--){
            shiftDown(root);
        }
    }
    //parent表示本次需要调整的节点的下标
    //调整之前保证parent的左右子树已经满足小堆的性质
    private void shiftDown(int parent){
        //先标记左孩子，因为parent可能有左没有右
        int child=2*parent+1;
        while (child<size){
            if(child+1<size && arr[child+1]<arr[child]){
                child=child+1;
            }
            if(arr[child]<arr[parent]){
                swap(parent,child);
                //parent较大的元素下移，可能会导致子树不满足堆的性质
                //继续下移调整
                parent=child;
                child=2*parent+1;
            }else {
                return;
            }
        }
    }

    //向上调整
    public void shiftUp(int child){
        int parent=(child-1)>>1;
        while (child!=0){
            if(arr[child]<arr[parent]){
                swap(child,parent);
                child=parent;
                parent=(child-1)>>1;
            }else {
                return;
            }
        }
    }


    //交换两个节点的值
    public void swap(int parent,int child){
        int temp=arr[parent];
        arr[parent]=arr[child];
        arr[child]=temp;
    }

   //获取堆顶元素
    public int peek(){
        return arr[0];
    }
    //向堆里插入元素
    public boolean offer(int k){
        arr[size++]=k;
        //此处不能用size--
        shiftUp(size-1);
        return true;
    }
    //删除堆顶元素
    int pop(){
        int ret=arr[0];
        swap(0,size-1);
        size--;
        shiftUp(0);
        return ret;
    }
}


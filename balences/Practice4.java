package lesson1;

/**
 * 排序
 */


public class Practice4 {
    public static void main(String[] args) {
        int[] array={6,3,5,2,7,1,0,8,9,4};
        Practice4 practice4=new Practice4();
       // practice4.select(array);
        //practice4.shellSelect(array);
        practice4.selectSort(array);
        practice4.display(array);
    }
    //插入排序
    public void select(int[] arr){
        for(int i=1;i<arr.length;i++){
            //key为要插入的那个数
            int key=arr[i];
            //它的前一个要比较的数
            int end=i-1;
            //end会向前移，但不能为0，当要比较的值小于前面的值时，
            //就将end位置的值放到end+1处
            while (end>=0&&key<arr[end]){
                arr[end+1]=arr[end];
                //end向前移，不断和前面元素比较
                end--;
            }
            //不符合情况将end+1处的值变为key
            arr[end+1]=key;
        }
    }
    //希尔排序
    public void shellSelect(int[] arr){
        int gap=arr.length;
        while (gap>1){
            //按照这种间隔数来分别直接插入排序
            gap=(gap/3)+1;
            for (int i=gap;i<arr.length;i++){
                //要插入的值
                int key=arr[i];
                int end=i-gap;
                while (end>=0&&key<arr[end]){
                    arr[end+gap]=arr[end];
                    end-=gap;
                }
                arr[end+gap]=key;
            }
        }
    }

    //选择排序
    public void selectSort(int[] arr){
        //选择的躺数
        for (int i=0;i<arr.length;i++){
            int maxPos=0;
            //具体选择的方式，找到最大元素的位置
            for(int j=1;j<arr.length-i;j++){
                if(arr[j]>arr[maxPos]){
                    maxPos=j;
                }
            }
            if(arr.length-1-i!=maxPos){
                int temp=arr[maxPos];
                arr[maxPos]=arr[arr.length-1-i];
                arr[arr.length-1-i]=temp;
            }
        }
    }

    public void display(int[] arr1){
        for (int e:arr1){
            System.out.print(e+" ");
        }
        System.out.println();
    }

}

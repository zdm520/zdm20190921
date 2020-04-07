
//归并排序递归实现

private static void mergeData(int[] arr,int left,int mid,int right,int[] temp){
     int index=left;
     int begin1=left,end1=mid,begin2=mid,end2=right;
     while (begin1<end1 && begin2<end2){
         if(arr[begin1]<=arr[begin2]){
             temp[index++]=arr[begin1++];
         }else {
             temp[index++]=arr[begin2++];
         }
     }
     while (begin1<end1){
         temp[index++]=arr[begin1++];
     }
     while (begin2<end2){
         temp[index++]=arr[begin2++];
     }
}

public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if(right-left>1){
            int mid=left+((right-left)>>1);
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid,right,temp);
            mergeData(arr,left,mid,right,temp);
            System.arraycopy(temp,left,arr,left,right-left);
        }
}

public static void mergeSort(int[] arr){
        int[] temp=new int[arr.length];
        mergeSort(arr,0,arr.length,temp);
}
package offer;

import java.util.*;

public class Gift {
    public static void main(String[] args) {
        int[] arr={1,2,3,2,2};
        int rs=getValue(arr,arr.length);
        System.out.println(rs);
    }
    public static int getValue(int[] gifts,int n){
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<n;i++){
            if(map.containsKey(gifts[i])){
                map.put(gifts[i],map.get(gifts[i])+1);
            }else {
                map.put(gifts[i],1);
            }
        }
        for(Map.Entry<Integer,Integer> x : map.entrySet()){
            if(x.getValue()>(n>>1)){
                return x.getKey();
            }
        }
        return 0;
    }
}



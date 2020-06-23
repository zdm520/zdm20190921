import java.util.List;
import java.util.ArrayList;
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n==0 || m==0){
            return -1;
        }
        int a = -1;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        while(list.size()>1){
            a = (a+m)%list.size();
            list.remove(a);
            a--;
        }
        return list.get(0);
    }
}
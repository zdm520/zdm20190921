import java.util.ArrayList;
import java.util.Arrays;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0 || array==null){
            return 0;
        }
        Arrays.sort(array);
        return array[0];
    }
}
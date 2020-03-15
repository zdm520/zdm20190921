//二位数组的查找

public class Solution {
    public boolean Find(int target, int [][] array) {
        int row=array.length;
        int col=array[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(array[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }
}
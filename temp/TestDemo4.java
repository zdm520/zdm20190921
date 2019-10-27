import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDemo4 {
    private final int CAPACITY=10;
    public int usedsize;
    public int[]elem;

    public TestDemo4() {
        this.usedsize = 0;
        this.elem = new int[CAPACITY];
    }
    public void print(){
        for (int i:elem){
            System.out.println(i);
        }
    }

    public void add(int pow, int date){
        if(pow<0||pow>=elem.length){
            System.out.println("位置不合法");
    }
        else if(pow==elem.length){
            elem=Arrays.copyOf(elem,elem.length*2);
        }
        else{
            for (int i=usedsize;i>=pow;i--){
                elem[i+1]=elem[i];
            }
            elem[pow]=date;
            usedsize++;
        }
    }
}

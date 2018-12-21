package leetcode.array;

/**
 * Created by mac on 2018/7/10.
 */
public class Movice {
    public int start;
    public int end;
    public Movice(int start,int end){
        this.start = start;
        this.end = end;
    }
    public boolean isIn(int o){
        if(o < end && o > start){
            return true;
        }
        return false;
    }
}

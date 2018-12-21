package leetcode.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by mac on 2018/7/10.
 */
public class FindMaxMovices {
    public int findMaxMovices(ArrayList<Movice> movices){
        Comparator<Movice> comparator = new Comparator<Movice>() {
            @Override
            public int compare(Movice o1, Movice o2) {
                return o1.end - o2.end;
            }
        };
        int count = 0;
        Collections.sort(movices,comparator);
        for (int i = 0 ; i < movices.size();i++){
            count++;
            int end = movices.get(i).end;
            for(int j = i + 1; j < movices.size(); j++){
               if(movices.get(j).isIn(end)){
                    i = j;
               }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FindMaxMovices findMaxMovices = new FindMaxMovices();
        int[][] movice = {{1,3},{2,4},{4,7},{5,6},{6,10},{3,9}};
        ArrayList<Movice> movices = new ArrayList<>();
        for(int i = 0 ; i < movice.length; i++){
            movices.add(new Movice(movice[i][0],movice[i][1]));
        }
        System.out.println(findMaxMovices.findMaxMovices(movices));
    }
}

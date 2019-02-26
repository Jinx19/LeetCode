package leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by mac on 2018/7/17.
 */
public class SortArrayForMinNumber {
    public String getMinNumber(int[] numbsers){
        if(numbsers == null || numbsers.length <= 0){
            return "";
        }

        ArrayList<String> strNumbers = new ArrayList<>();
        for(int i = 0 ; i < numbsers.length ; i++){
            strNumbers.add(String.valueOf(numbsers[i]));
        }
        Collections.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String combine1 = o1.concat(o2);
                String combine2 = o2.concat(o1);
                return Integer.valueOf(combine1) - Integer.valueOf(combine2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int  i = 0; i < numbsers.length; i++){
            sb.append(strNumbers.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SortArrayForMinNumber sortArrayForMinNumber = new SortArrayForMinNumber();
        int[] numbsers = {3,32,321};
        System.out.println(sortArrayForMinNumber.getMinNumber(numbsers));
    }
}

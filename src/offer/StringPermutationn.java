package offer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringPermutationn {
    public void helper(char[] temp,int length,int index,List<String> permutations){
        if(index == length - 1){
            permutations.add(new String(temp));
            return;
        }
        char c = temp[index];
        for(int i = index; i < length; i++){
            temp[index] = temp[i];
            temp[i] = c;
            helper(temp,length,index + 1,permutations);
            temp[i] = temp[index];
            temp[index] = c;
        }
    }
    List<String> permutation(String str){
        List<String> permutations = new ArrayList<>();
        helper(str.toCharArray(),str.length(),0,permutations);
        return permutations;
    }

    public static void main(String[] args) {
        StringPermutationn stringPermutationn = new StringPermutationn();
        List<String> permutations = stringPermutationn.permutation("abc");
        for(String str : permutations){
            System.out.println(str);
        }
    }
}

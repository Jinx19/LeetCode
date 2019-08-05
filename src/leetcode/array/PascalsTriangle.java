package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if(numRows < 0){
            return ans;
        }
        if(numRows == 1){
            ans.add(Arrays.stream(new int[]{1}).boxed().collect(Collectors.toList()));
            return ans;
        }
        if(numRows == 2){
            ans.add(Arrays.stream(new int[]{1}).boxed().collect(Collectors.toList()));
            ans.add(Arrays.stream(new int[]{1,1}).boxed().collect(Collectors.toList()));
            return ans;
        }

        ans.add(Arrays.stream(new int[]{1}).boxed().collect(Collectors.toList()));
        ans.add(Arrays.stream(new int[]{1,1}).boxed().collect(Collectors.toList()));

        for(int i = 3; i <= numRows; i++){
            List<Integer> preRow = ans.get(i - 1);
            int[] newRow = new int[i];
            newRow[0] = 1;
            newRow[i - 1] = 1;
            for(int j = 1; j < i - 1; j++){
                newRow[j] = preRow.get(j - 1) + preRow.get(j);
            }
            ans.add(Arrays.stream(newRow).boxed().collect(Collectors.toList()));
        }
        return ans;
    }
}

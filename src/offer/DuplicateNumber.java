package src.offer;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DuplicateNumber {
    public int duplication = -1;
    boolean duplicate(int[] numbers){
        if(numbers == null || numbers.length < 2){
            return false;
        }
        int n = numbers.length;
        for(int i = 0; i < n; i++){
            while (numbers[i] != i){
                if(numbers[numbers[i]] == numbers[i]){
                    duplication = numbers[i];
                    return true;
                }

                int temp = numbers[i];
                numbers[i] = numbers[numbers[i]];
                numbers[temp] = temp;
            }
        }
        return false;
    }

}

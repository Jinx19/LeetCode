package offer;

import java.util.Arrays;

public class Print1ToMaxOfNDigits {
    public void print1ToMaxOfNDigitis(int n){
        if(n<=0){
            return;
        }

        char[] number = new char[n];
        for(int i = 0 ; i < 10; i++){
            number[0] = (char)(i + '0');
            helper(number,n,0);
        }
    }
    private void helper(char[] number, int n, int i) {
        if(i == n - 1){
            printNumber(number);
            return;
        }
        for(int j = 0; j < 10; j++){
            number[i + 1] = (char)(i + '0');
            helper(number,n,i+1);
        }
    }

    private void printNumber(char[] numbers) {
        boolean isBeginning0 = true;

        for(char c : numbers){
            if(isBeginning0 && c != '0'){
                isBeginning0 = false;
            }
            if(!isBeginning0){
                System.out.print(c);
            }
        }

        System.out.println();
    }


    public static void main(String[] args) {
        Print1ToMaxOfNDigits print1ToMaxOfNDigits = new Print1ToMaxOfNDigits();
        print1ToMaxOfNDigits.print1ToMaxOfNDigitis(100000);
    }
}

package array;

/**
 * Created by mac on 2018/7/18.
 */
public class InversePairs {
    public static int[] aux;
    public static int  InversePairs(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }

        aux = new int[array.length];
        int count = InversePairsCore(array, 0, array.length - 1);
        return count;
    }

    public static int InversePairsCore(int[] array, int start, int end) {
        if (start == end) {
            aux[start] = array[start];
            return 0;
        }

        int length = (end - start) >> 1;

        int left = InversePairsCore(array, start, start + length);
        int right = InversePairsCore(array, start + length + 1, end);

        int i = start + length;
        int j = end;

        int indexCopy = end;

        int count = 0;

        while (i >= start && j >= start + length + 1) {
            if (array[i] > array[j]) {
                aux[indexCopy--] = array[i--];
                count += j - start - length;
            } else {
                aux[indexCopy--] = array[j--];
            }
        }

        for (; i >= start; --i)
            aux[indexCopy--] = array[i];

        for (; j >= start + length + 1; --j)
            aux[indexCopy--] = array[j];
        for(i = start; i <= end; i++){
            array[i] = aux[i];
        }
        return left + right + count;
    }

    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,6,7,0};
        System.out.println(InversePairs.InversePairs(data));
    }
}


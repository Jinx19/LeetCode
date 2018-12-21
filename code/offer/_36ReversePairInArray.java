package code.offer;

public class _36ReversePairInArray {
    public static int[] aux;
    public int InversePairs(int [] array) {
        if (array == null || array.length < 2) {
            return 0;
        }

        aux = new int[array.length];
        long count = InversePairsCore(array, 0, array.length - 1);
        return (int)(count % 1000000007);
    }
    public long InversePairsCore(int[] array,int start, int end){
        if (start == end) {
            aux[start] = array[start];
            return 0;
        }

        int length = (end - start) >> 1;

        long left = InversePairsCore(array, start, start + length);
        long right = InversePairsCore(array, start + length + 1, end);

        int i = start + length;
        int j = end;

        int indexCopy = end;

        long count = 0;

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
        _36ReversePairInArray reversePairInArray = new _36ReversePairInArray();
        int[] nums = {7,5,6,4};
        reversePairInArray.InversePairs(nums);
    }
}

package offer;

public class InversePairs {
    private int inversePairs(int[] data) {
        if (data == null || data.length < 2) {
            return 0;
        }

        int[] copy = new int[data.length];
        System.arraycopy(data,0,copy,0,data.length);

        return helper(data, copy, 0, data.length - 1);
    }

    private int helper(int[] data, int[] copy, int start, int end) {
        if(start == end){
            copy[start] = data[end];
            return 0;
        }

        int mid = start + (end - start) / 2;
        int leftCount = helper(copy, data, start, mid);
        int rightCount = helper(copy, data, mid + 1, end);

        int i = mid;
        int j = end;
        int indexCopy = end;
        int count = 0;

        while (i >= start && j >= mid + 1){
            if(data[i] > data[j]){
                copy[indexCopy--] = data[i--];
                count += j - mid;
            }else{
                copy[indexCopy--] = data[j--];
            }
        }

        for(;i>=start;--i){
            copy[indexCopy--] = data[i];
        }

        for(;j>=mid+1;--j){
            copy[indexCopy--] = data[j];
        }
        return leftCount + rightCount + count;

    }


    public static void main(String[] args) {
        int[] data = {7, 6, 5, 4};
        InversePairs inversePairs = new InversePairs();
        int res = inversePairs.inversePairs(data);
        System.out.println(res);
    }
}

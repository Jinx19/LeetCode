package leetcode.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * 
 * @author mac
 * 三步翻转法
1.先找到分割点a,b
2.翻转前半部分，后半部分翻转
3.最后整体翻转
翻转的in-place实现。
使用两个指针，一个指头，一个指尾，使用for循环移位交换。
 *
 */
public class RecoverRotatedSortedArray {
	public void rotate(List<Integer> nums, int begin, int end) {
		while (begin < end) {
			int temp = nums.get(begin);
			nums.set(begin, nums.get(end));
			nums.set(end, temp);
			begin++;
			end--;
		}
	}

	public void recoverRotatedSortedArray(List<Integer> nums) {
		// write your code here
		int i = 0;
		while (i < nums.size() - 1 && nums.get(i) <= nums.get(i + 1)) {
			i++;
		}
		if (i != nums.size()) {
			rotate(nums, 0, 1);
			rotate(nums, i + 1, nums.size() - 1);
			rotate(nums, 0, nums.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = { 1, 1, 1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		List<Integer> nums = new ArrayList<>();
		for (int i : num) {
			nums.add(i);
		}
		RecoverRotatedSortedArray sl = new RecoverRotatedSortedArray();
		sl.recoverRotatedSortedArray(nums);
		Iterator<Integer> it = nums.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}

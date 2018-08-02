package tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class SerializeandDeserializeBST {
	public String serialize(TreeNode root) {
		if (root == null) {
			return new String("");
		}
		StringBuilder sb = new StringBuilder();
		Stack<TreeNode> st = new Stack<>();
		st.push(root);
		while (!st.empty()) {
			root = st.pop();
			sb.append(root.val).append(",");
			if (root.right != null)
				st.push(root.right);
			if (root.left != null)
				st.push(root.left);
		}
		return sb.toString();
	}

	public TreeNode deserialize(String data) {
		if (data.equals(null))
			return null;
		String[] strs = data.split(",");
		Queue<Integer> q = new LinkedList<>();
		for (String e : strs) {
			q.offer(Integer.parseInt(e));
		}
		return getNode(q);
	}

	private TreeNode getNode(Queue<Integer> q) { // q: 5,3,2,6,7
		if (q.isEmpty())
			return null;
		TreeNode root = new TreeNode(q.poll());// root (5)
		Queue<Integer> samllerQueue = new LinkedList<>();
		while (!q.isEmpty() && q.peek() < root.val) {
			samllerQueue.offer(q.poll());
		}
		// smallerQueue : 3,2 storing elements smaller than 5 (root)
		root.left = getNode(samllerQueue);
		// q: 6,7 storing elements bigger than 5 (root)
		root.right = getNode(q);
		return root;
	}

	public static void put(TreeMap<Integer, ArrayList<Integer>> map, int key, int index) {
		if (!map.containsKey(key)) {
			ArrayList<Integer> indexs = new ArrayList<>();
			indexs.add(index);
			map.put(key, indexs);
		} else {
			ArrayList<Integer> indexs = map.get(key);
			indexs.add(index);
		}
	}

	public static void main(String[] args) {
		Comparator<Integer> com = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if (o1 > o2) {
					return -1;
				} else if (o1 < o2) {
					return 1;
				} else {
					return 0;
				}
			}
		};
		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>(com);
		put(map, 3, 1);
		put(map, 4, 2);
		put(map, 5, 3);
		put(map, 3, 4);
		put(map, 2, 5);
		int max = map.firstKey();
		ArrayList<Integer> indexs = map.get(max);
		if(indexs.size() > 1) {
			
		}

	}
}

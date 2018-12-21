package leetcode.tree;

/**
 * Created by mac on 2018/7/10.
 */
public class Node {
    Node pLeft;    //左孩子
    Node pRight;   //右孩子
    int nMaxLeft;  //左子树中的最长距离
    int nMaxRight; //右子树中的最长距离
    char chValue;  //该节点的值
    public Node(char c){
        this.chValue = c;
    }
}

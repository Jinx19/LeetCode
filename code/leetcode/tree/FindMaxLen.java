package leetcode.tree;

import leetcode.array.FindMaxMovices;

/**
 * Created by mac on 2018/7/10.
 */
public class FindMaxLen {
    int nMaxLen = 0;

    //寻找树中最长的两段距离
    void FindMaxLen(Node pRoot){
        if(pRoot == null){
            return;
        }

        //如果左子树为空，那么该节点的左边最长距离为0
        if(pRoot.pLeft == null){
            pRoot.nMaxLeft = 0;
        }
        //如果右子树为空，那么该节点的右边最长距离为0
        if(pRoot.pRight == null){
            pRoot.nMaxRight = 0;
        }
        //如果左子树不为空，递归寻找左子树最长距离
        if(pRoot.pLeft != null){
            FindMaxLen(pRoot.pLeft);
        }
        //如果右子树不为空，递归寻找右子树最长距离
        if(pRoot.pRight != null){
            FindMaxLen(pRoot.pRight);
        }
        //计算左子树最长节点距离
        if(pRoot.pLeft != null){
            int nTempMax = 0;
            if(pRoot.pLeft.nMaxLeft > pRoot.pLeft.nMaxRight){
                nTempMax = pRoot.pLeft.nMaxLeft;
            }else{
                nTempMax = pRoot.pLeft.nMaxRight;
            }
            pRoot.nMaxLeft = nTempMax + 1;
        }

        //计算右子树最长节点距离
        if(pRoot.pRight != null){
            int nTempMax = 0;
            if(pRoot.pRight.nMaxLeft > pRoot.pRight.nMaxRight){
                nTempMax = pRoot.pRight.nMaxLeft;
            }else{
                nTempMax = pRoot.pRight.nMaxRight;
            }
            pRoot.nMaxRight = nTempMax + 1;
        }

        if(pRoot.nMaxLeft + pRoot.nMaxRight > nMaxLen){
            nMaxLen = pRoot.nMaxLeft + pRoot.nMaxRight;
        }
    }

    public static void main(String[] args) {
        int a = 1,b = 2;
        System.out.println("a:" + a + "," + "b:" + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a:" + a + "," + "b:" + b);
    }
}

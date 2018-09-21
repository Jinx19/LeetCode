package offer;

import leetcode.linkedlist.ListNode;

/**
 * Created by mac on 2018/9/7.
 */
public class _056EntryNodeInListLoop {
    public int getNumberInLoop(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return 0;
        }
        ListNode fastP = pHead;
        ListNode slowP = pHead;
        slowP = slowP.next;
        fastP = fastP.next.next;
        while(fastP != slowP){
            slowP = slowP.next;
            fastP = fastP.next.next;
        }
        int count = 1;
        while(slowP.next != fastP){
            slowP = slowP.next;
            count++;
        }
        return count;
    }
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        int num = getNumberInLoop(pHead);
        if(num == 0){
            return null;
        }
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while(num > 0){
            p1 = p1.next;
            num--;
        }
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        _056EntryNodeInListLoop solution = new _056EntryNodeInListLoop();
        ListNode head = new ListNode(1);
        ListNode it = head;
        ListNode ent = null;
        for(int i = 2; i <= 6; i++){

            if(i == 4){
                it.next = new ListNode(i);
                it = it.next;
                ent = it;
            }else{
                it.next = new ListNode(i);
                it = it.next;
            }
        }
        it.next = ent;
        solution.EntryNodeOfLoop(head);
    }
}

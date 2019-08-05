package leetcode.linkedlist;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode p = head;
        while(p != null){
            if(p.val == val){
                if(p == head){
                    p = p.next;
                    head = p;
                }else if(p.next != null){
                    p.val = p.next.val;
                    p.next = p.next.next;
                }else{
                    ListNode dummpy = head;
                    while(dummpy.next.val != val ){
                        dummpy = dummpy.next;
                    }
                    dummpy.next = null;
                    p = null;
                }
            }else{
                p = p.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveLinkedListElements removeLinkedListElements = new RemoveLinkedListElements();
        int[] nums = {1};
        ListNode head = new ListNode(nums[0]);
        ListNode dumpy = head;
        for(int i = 1; i < nums.length; i++){
            ListNode listNode = new ListNode(nums[i]);
            dumpy.next = listNode;
            dumpy = dumpy.next;
        }

        ListNode listNode = removeLinkedListElements.removeElements(head,1);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

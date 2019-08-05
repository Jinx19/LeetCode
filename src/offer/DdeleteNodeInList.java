package offer;
public class DdeleteNodeInList {
    public void deleteNode(ListNode head,ListNode node){
        if(node.next != null){
            node.value = node.next.value;
            node.next = node.next.next;
        }else if(node == head){
            head = node.next;
        }else{
            ListNode p = head;
            while(p.next != node){
                p = p.next;
            }
            p.next = null;
        }
    }
}

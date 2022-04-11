package codetop;

/**
 * @author Zero
 * @date 2022/4/10 10:50
 * @description
 * @since 1.8
 **/
public class 奇偶链表 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return head;
        }
        //奇数节点头
        ListNode pre = head;
        //偶数节点头
        ListNode next = head.next;
        ListNode tmp = next;
        while(tmp != null && tmp.next != null) {
            pre.next = tmp.next;
            pre = pre.next;
            tmp.next = pre.next;
            tmp = tmp.next;
        }
        pre.next = next;
        return head;
    }
}

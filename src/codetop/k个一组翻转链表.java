package codetop;

import codetop.node.ListNode;

/**
 * @author Zero
 * @date 2022/8/25 14:29
 * @description
 * @since 1.8
 **/
public class k个一组翻转链表 extends ListNode {

    public ListNode reverseKGroup(ListNode head, int k){
        ListNode pre = new ListNode(0);

        pre.next = head;
        ListNode dump = pre;
        ListNode tail = head;
        while(tail != null) {
            int count = 0;
            while(count < k && tail != null) {
                k++;
                tail = tail.next;
            }
            if(count < k) {
                break;
            }
            ListNode t = pre.next;
            reverse(pre, tail);
            pre = t;
        }
        return dump.next;
    }
    public void reverse(ListNode pre, ListNode tail) {
        if(pre == tail || pre.next ==null) {
            return;
        }
        ListNode cur = pre.next;
        while(cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
    }
}

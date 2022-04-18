package leet;

/**
 * @author Zero
 * @date 2022/4/7 15:41
 * @description
 * @since 1.8
 **/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class 环形链表II {
    //找到快慢指针交汇节点，然后找出环长，
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        //找到第一次相遇的点（根据数学计算得到目前慢指针已经走了n个环的长度），而起点到入口长度+n*环长度 = 环的入口点，那么此时只要慢指针再移动起点到入口长度即可。
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}

package codetop;


import java.util.List;

/**
 * @author Zero
 * @date 2022/8/30 11:27
 * @description
 * @since 1.8
 **/
public class Test extends ListNode{
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode h = head;
        for(int i = 1; i < 10; i++) {
            head.next = new ListNode(i);
            head = head.next;
        }
        ListNode list =  reverse(h.next);
        print(list);
    }
    public static void print(ListNode list) {
        while(list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
    }

    private static ListNode reverse(ListNode root) {
        ListNode dump = new ListNode(-1);
        dump.next = root;
        ListNode cur = root;
        while(cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = dump.next;
            dump.next = next;
        }
        return dump.next;
    }
}

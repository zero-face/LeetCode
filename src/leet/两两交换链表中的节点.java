package leet;

/**
 * @author Zero
 * @date 2022/3/25 13:13
 * @description
 * @since 1.8
 **/
public class 两两交换链表中的节点 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            //找到要交换的第一个节点
            ListNode node1 = temp.next;
            //第二个要交换的界定啊
            ListNode node2 = temp.next.next;
            //开始交换
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            //temp指向下一个要交换节点的前驱节点
            temp = node1;
        }
        return dummyHead.next;
    }
}

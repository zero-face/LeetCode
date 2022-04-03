package codetop;

/**
 * @author Zero
 * @date 2022/3/28 10:40
 * @description
 * @since 1.8
 **/
public class 删除链表中重复的元素II {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return head;
        }
        //构造一个头节点
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode cur = h;
        while(cur.next != null && cur.next.next != null) {
            //找到重复节点，保存第一个重复节点的值，然后循环删除掉所有的节点
            if(cur.next.val == cur.next.next.val) {
                int k = cur.next.val;
                while(cur.next != null && cur.next.val == k) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return h.next;
    }
}

package codetop;

/**
 * @author Zero
 * @date 2022/3/28 10:45
 * @description 思想：穿针引线，就是将要反转的部分，从第一节点开始，将后面的节点依次放在最前面这样，反转序列完了之后整个链表就反转过来
 * @since 1.8
 **/
public class 反转链表II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        //找到要反转节点的上一个节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        //cur表示要开始反转部分
        ListNode cur = pre.next;
        ListNode next;
        //采用穿针引线，过程是让下一个结点放到前面
        for (int i = 0; i < right - left; i++) {
            //保存当前节点的下一个结点
            next = cur.next;
            //当前节点指到下一个结点的下一个结点
            cur.next = next.next;
            //下一个结点指到头结点的下一个结点（不能指到当前节点，因为是要把后面以此放在最前面，当前节点会随着后移前面还有很多节点是上一轮放的）
            next.next = pre.next;
            //头节点指到下一个结点
            pre.next = next;
            //如此一轮循环就将下一个节点放到当前节点的前面了
        }
        return dummyNode.next;
    }
}

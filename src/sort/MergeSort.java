package sort;

import java.util.Arrays;

/**
 * @author Zero
 * @date 2021/11/21 19:39
 * @description 二路归并排序（自顶向下）；自底向上的归并
 * @since 1.8
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[] {1,23,445,43,564,43};
        merger(nums,0, nums.length - 1,new int[nums.length]);
        System.out.println(Arrays.toString(nums));
    }
    //自底向上的归并（链表排序）
    public ListNode sortList(ListNode head) {
        if(head == null) {
            return head;
        }
        int n = 0;
        ListNode h = head;
        //求链表长度
        while(h != null) {
            n++;
            h = h.next;
        }
        //构建头节点
        ListNode node = new ListNode(0, head);
        //以长度为i的链表节点为单位进行两两归并
        for(int i = 1; i < n; i <<= 1) {
            ListNode pre = node;
            ListNode cur = node.next;
            //每次都找到两个长度为i的链表长度
            while(cur != null) {
                //找到第一个长度为i的列表
                ListNode h1 = cur;
                //当长度为1的时候根本不用移动，所以这里j=1，条件是j<i
                for(int j = 1; j < i &&  cur != null && cur.next != null; j++) {
                    cur = cur.next;
                }
                //找到第二个链表长度为i的的链表
                ListNode h2 = cur.next;
                cur.next = null;
                cur = h2;
                for(int k = 1; k < i && cur != null && cur.next != null; k++) {
                    cur = cur.next;
                }
                //剩下的链表为next
                ListNode next = null;
                if(cur != null) {
                    next = cur.next;
                    cur.next = null;
                }
                //合并长度为i的两个链表
                ListNode merged = merger(h1, h2);
                //将合并的后的链表放在头节点后面
                pre.next = merged;
                //移动头节点到合并后的最后一个节点
                while(pre.next != null) {
                    pre = pre.next;
                }
                //将当前节点指到剩下的链表next，继续找接下来要归并的两个链表，直到当前节点为null
                cur = next;
            }
        }
        return node.next;
    }

    //归并两个链表
    public ListNode merger(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null) {
            cur.next = l1;
        } else if(l2 != null) {
            cur.next = l2;
        }
        return head.next;
    }


    /**
     * 自顶向下的归并
     * @param nums
     * @param left
     * @param right
     * @param temp
     */
    public static void merger(int[] nums, int left,int right,int[] temp) {
        if(left < right) {
            //确定中点
            int mid = (left + right) / 2;
            //合并左边
            merger(nums, left, mid, temp);
            //合并右边
            merger(nums,mid + 1, right, temp);
            //两路合并
            merge(nums, left, mid, right, temp);
        }
    }
    //两路归并m + n
    private static void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while(i <= mid && j <= right) {
            if(nums[i] <= nums[j]) {
                temp[t++] = nums[i++];
            } else {
                temp[t++] = nums[j++];
            }
        }
        while(i <= mid) {
            temp[t++] = nums[i++];
        }
        while(j <= right) {
            temp[t++] = nums[j++];
        }
        //将临时数组复制会原数组
        t= 0;
        while(left <= right) {
            nums[left++] = temp[t++];
        }
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
package codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zero
 * @date 2022/3/25 11:58
 * @description
 * @since 1.8
 **/
public class LRU缓存 {
    //声明结点结构（双向链表）
    class ListNode{
        int key;
        int val;
        ListNode pre, next;
        public ListNode() {}
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    //map存放结点（map中存放的都是list中有的节点）（相当于map用于快速获取结点，list维护节点的顺序）
    private Map<Integer,ListNode> maps = new HashMap<>();
    //点明结点容量
    private int cap;
    //当前长度
    private int size;
    //头尾结点
    private ListNode head, tail;
    public LRU缓存(int cap) {
        this.cap = cap;
        this.size = 0;
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.pre = head;
    }
    //获取结点
    public int get(int key) {
        // 从map中获取结点（不包含则会返回null）
        ListNode node = maps.get(key);
        if(node != null) {
            //如果获取到了还会移动到头部(删除节点，然后头部添加节点)
            moveToHead(node);
            return node.val;
        }
        return -1;
    }
    public void put(int key, int val) {
        ListNode node = maps.get(key);
        if(node == null) {
            //没有则新建节点
            ListNode node1 = new ListNode(key, val);
            //map中保存
            maps.put(key, node1);
            //节点添加到头部
            addToHead(node1);
            ++size;
            if(size > cap) {
                //移除最后节点
                ListNode last = removeTail();
                //删除map（删除节点，返回删除的节点）
                maps.remove(last.key);
                --size;
            }
        } else {
            //覆盖值
            node.val = val;
            //移动到头部
            moveToHead(node);
        }
    }
    //双向链头插
    public void addToHead(ListNode node) {
        //节点后继是head的后面一个
        node.next = head.next;
        //节点的前驱是头节点
        node.pre= head;
        //后面一个节点的前驱是该节点
        head.next.pre = node;
        //头节点的后继是该节点
        head.next = node;

    }

    //删除节点
    public void removeNode(ListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    //删除尾部（删除尾指针的前面结点）
    public ListNode removeTail() {
        ListNode res = tail.pre;
        removeNode(res);
        return res;
    }
    //移动到头部
    public void moveToHead(ListNode node) {
        removeNode(node);
        addToHead(node);
    }
}

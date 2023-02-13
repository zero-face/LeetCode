//package interview.yige;
//
//import javax.management.remote.rmi._RMIConnection_Stub;
//import java.util.ArrayDeque;
//import java.util.Deque;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author Zero
// * @date 2022/10/11 19:37
// * @description
// * @since 1.8
// **/
//class node {
//    int val;
//    int key;
//    node next;
//    node pre;
//    public node(int key, int val){}
//}
//public class test  {
//    private int size = 0;
//    private int cap = 0;
//    Deque<node> list;
//    Map<Integer, node> map;
//
//    public test(int cap) {
//        list = new ArrayDeque<>();
//        map = new HashMap<>();
//        this.cap = cap;
//    }
//
//    public int get(int key) {
//        node n = map.get(key);
//        if(n != null) {
//            moveToHead(n);
//            return n.val;
//        }
//        return 0;
//    }
//
//    public void put(int key, int val) {
//        node n = map.get(key);
//        if(n == null) {
//            addToHead(new node())
//        }
//    }
//    public static void main(String[] args) {
//
//    }
//}

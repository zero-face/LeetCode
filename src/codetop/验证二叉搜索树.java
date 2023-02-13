package codetop;

import codetop.node.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Zero
 * @date 2022/4/21 20:04
 * @descripclass * @since 1.8
 **/

public class 验证二叉搜索树 extends codetop.node.TreeNode {
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return false;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        long flag = -Long.MAX_VALUE;
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            if(node.val <= flag) {
                return false;
            }
            flag = node.val;
            root = node.right;
        }
        return true;
    }
}

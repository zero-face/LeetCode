package leet;
/**
 * @author Zero
 * @date 2022/3/27 20:20
 * @description
 * @since 1.8
 **/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }
public class 二叉搜索树的前序遍历构造二叉树 {
    public TreeNode bstFromPreorder(int[] preorder) {
        return dfs(preorder, 0, preorder.length);
    }
    public TreeNode dfs(int[] preorder, int start, int end) {
        if(start >= end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        int i = 0;
        for(i = start + 1; i < end; i++) {
            if(preorder[i] > preorder[start]) {
                break;
            }
        }
        root.left = dfs(preorder, start + 1, i);
        root.right = dfs(preorder, i, end);
        return root;
    }
}

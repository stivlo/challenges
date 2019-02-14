package trees.count_unival;

import trees.model.TreeNode;

// this solution takes O(n^2)
// https://www.lintcode.com/problem/count-univalue-subtrees/description
public class Solution {

    static int countUnival(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int uniCount = 0;
        if (isUnival(root.left, root.right, root.val)) {
            uniCount++;
        }
        uniCount += countUnival(root.left) + countUnival(root.right);
        return uniCount;
    }

    private static boolean isUnival(TreeNode left, TreeNode right, int val) {
        return isUnival(left, val) && isUnival(right, val);
    }

    private static boolean isUnival(TreeNode root, int val) {
        if (root == null) return true;
        if (root.val != val) return false;
        return isUnival(root.left, val) && isUnival(root.right, val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(1);
        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(1);
        root.right.right = new TreeNode(0);
        System.out.println(countUnival(root));
    }
}

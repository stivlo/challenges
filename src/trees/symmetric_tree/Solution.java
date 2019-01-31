package trees.symmetric_tree;

import trees.model.TreeNode;

// Symmetric Tree
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/627/
// Tutorial: https://www.youtube.com/watch?v=rLokebzsbyg
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val != node2.val) return false;
        return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }

}

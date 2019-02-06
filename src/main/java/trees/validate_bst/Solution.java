package trees.validate_bst;

import trees.model.TreeNode;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/625/
 *
 * To check if it's a valid binary tree I perform an in-order traversal and I keep track of the
 * previous value and I make sure that the previous value is always lower than the current one.
 * An empty tree is a valid tree.
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private Integer prevVal = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean isValid = isValidBST(root.left);
        if (prevVal != null && prevVal >= root.val) return false;
        prevVal = root.val;
        isValid &= isValidBST(root.right);
        return isValid;
    }

}
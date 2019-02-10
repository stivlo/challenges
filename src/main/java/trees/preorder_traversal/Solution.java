package trees.preorder_traversal;

import trees.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-preorder-traversal/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        traverse(root, values);
        return values;
    }

    private static void traverse(TreeNode root, List<Integer> values) {
        if (root != null) {
            // visit root
            values.add(root.val);
            // visit left subtree
            traverse(root.left, values);
            // visit right subtree
            traverse(root.right, values);
        }
    }
}
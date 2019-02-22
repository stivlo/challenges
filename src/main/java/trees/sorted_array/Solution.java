package trees.sorted_array;

import trees.model.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        sortedArrayToBST(root, nums, 0, mid - 1);
        sortedArrayToBST(root, nums, mid + 1, nums.length - 1);
        return root;
    }

    private void sortedArrayToBST(TreeNode parent, int[] nums, int start, int end) {
        if (start > end) {
            return;
        }
        int mid = (start + end) / 2;
        TreeNode child = new TreeNode(nums[mid]);
        if (child.val <= parent.val) {
            parent.left = child;
        } else {
            parent.right = child;
        }
        sortedArrayToBST(child, nums, start, mid - 1);
        sortedArrayToBST(child, nums, mid + 1, end);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().sortedArrayToBST(new int[]{2, 3}));
        System.out.println(new Solution().sortedArrayToBST(new int[]{2, 3, 4}));
        System.out.println(new Solution().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }

}
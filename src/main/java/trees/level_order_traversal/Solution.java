package trees.level_order_traversal;

import trees.model.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        if (root != null) q.addFirst(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curNode = q.pollLast();
                row.add(curNode.val);
                if (curNode.left != null) q.addFirst(curNode.left);
                if (curNode.right != null) q.addFirst(curNode.right);
            }
            res.add(row);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        List<List<Integer>> res = new Solution().levelOrder(root);
        System.out.println(res);
    }

}

package trees.serialise_deserialise;

import trees.model.TreeNode;

// https://leetcode.com/problems/serialize-and-deserialize-bst/submissions/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private static final String NULL = "N";
    private static final String SEP = " ";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serialize(root, new StringBuilder()).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(SEP);
        return deserialize(tokens, new Index());
    }

    private StringBuilder serialize(TreeNode root, StringBuilder repr) {
        if (repr.length() > 0) repr.append(SEP);
        if (root == null) {
            repr.append(NULL);
        } else {
            repr.append(root.val);
            serialize(root.left, repr);
            serialize(root.right, repr);
        }
        return repr;
    }

    private TreeNode deserialize(String[] tokens, Index index) {
        if (index.i >= tokens.length || tokens[index.i].equals(NULL)) {
            index.i++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(tokens[index.i]));
        index.i++;
        root.left = deserialize(tokens, index);
        root.right = deserialize(tokens, index);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Codec codec = new Codec();
        String s = codec.serialize(root);
        System.out.println(s);
        String p = codec.serialize(codec.deserialize(s));
        System.out.println(p);
    }

    private class Index {
        int i = 0;
    }

}

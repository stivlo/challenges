package strings.longest_common_prefix;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Solution {

    public String longestCommonPrefix(String[] strs) {
        TrieNode root = new TrieNode('.');
        for (String str : strs) {
            root.addWord(str);
        }
        int size = strs.length;
        return root.findCommonPrefix(size, root);
    }

    class TrieNode {
        char aChar;
        int count = 0;
        Map<Character, TrieNode> children = new HashMap<>();

        TrieNode(char aChar) {
            this.aChar = aChar;
        }

        void addWord(String word) {
            TrieNode current = this;
            for (int i = 0; i < word.length(); i++) {
                char curChar = word.charAt(i);
                TrieNode charNode = current.children.get(curChar);
                if (charNode == null) charNode = new TrieNode(curChar);
                charNode.count++;
                current.children.put(curChar, charNode);
                current = charNode;
            }
        }

        String findCommonPrefix(int size, TrieNode root) {
            for (Map.Entry<Character, TrieNode> child : root.children.entrySet()) {
                if (child.getValue().count == size) {
                    return child.getKey() + findCommonPrefix(size, child.getValue());
                }
            }
            return "";
        }
    }

    public static void main(String[] args) {
        assertThat(new Solution().longestCommonPrefix(new String[] {"flower", "flow", "flight"}), is("fl"));
        assertThat(new Solution().longestCommonPrefix(new String[] {"dog", "flow", "flight"}), is(""));
    }

}

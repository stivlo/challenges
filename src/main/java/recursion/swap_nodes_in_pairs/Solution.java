package recursion.swap_nodes_in_pairs;

import linked_list.model.ListNode;

// https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1681/
// Given 1->2->3->4, you should return the list as 2->1->4->3.
public class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null) return  null;
        if (head.next == null) return head;
        ListNode secondNode = head.next;
        ListNode thirdNode = secondNode.next;
        secondNode.next = head;
        head.next = swapPairs(thirdNode);
        return secondNode;
    }

}

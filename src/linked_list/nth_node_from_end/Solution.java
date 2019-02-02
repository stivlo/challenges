package linked_list.nth_node_from_end;

import linked_list.model.ListNode;

// remove nth node from end of list
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/603/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // naive solution: count total nodes and then scan the list again
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = size(head);
        if (n > size) return head;
        if (size == 1) return null;
        int nodeToFind = size - n;
        if (nodeToFind == 0) return head.next;
        ListNode node = findNode(head, nodeToFind);
        node.next = node.next.next;
        return head;
    }

    private int size(ListNode head) {
        ListNode current = head;
        int size = 0;
        while (current != null) {
            current = current.next;
            size++;
        }
        return size;
    }

    private ListNode findNode(ListNode head, int n) {
        ListNode current = head;
        int pos = 1;
        while (current != null && pos < n) {
            current = current.next;
            pos++;
        }
        return current;
    }

}
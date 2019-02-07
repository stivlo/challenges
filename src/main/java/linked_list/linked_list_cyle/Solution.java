package linked_list.linked_list_cyle;

import linked_list.model.ListNode;

// Linked list cycle
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/773/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode s = head;
        ListNode f = head;
        while (s != null && f != null) {
            s = s.next;
            f = f.next;
            if (f != null) {
                f = f.next;
                if (s == f) return true;
            }
        }
        return false;
    }
}
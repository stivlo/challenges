package linked_list.palindrome_linked_list;

import linked_list.model.ListNode;

import java.util.Deque;
import java.util.LinkedList;

// Palindrome Linked List
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/772/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode s = head;
        ListNode f = head;
        while (f != null) {
            s = s.next;
            if (s == null) return true;
            f = f.next;
            if (f != null) f = f.next;
        }
        Deque<Integer> stack = new LinkedList<>();
        while (s != null) {
            stack.addFirst(s.val);
            s = s.next;
        }
        ListNode p = head;
        while (!stack.isEmpty()) {
            int val = stack.removeFirst();
            if (val != p.val) return false;
            p = p.next;
        }
        return true;
    }
}
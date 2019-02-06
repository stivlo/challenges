package linked_list.nth_node_from_end;

import linked_list.model.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class SolutionV2 {

    // in one pass using two pointers (slow and fast)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode s = head;
        ListNode f = head;
        for (int i = 0; i < n; i++) {
            f = f.next;
        }
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next;
        }
        if (s == f || f == null) {
            return head.next;
        }
        s.next = s.next.next;
        return head;
    }

}
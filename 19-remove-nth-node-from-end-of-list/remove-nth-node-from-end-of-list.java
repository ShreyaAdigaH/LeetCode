/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // if(head.next == null && n == 1) {
        //     return new ListNode();
        // } else if(head.next.next == null) {
        //     if(n == 1) {
        //         return new ListNode(head.val);
        //     } else if(n == 2) {
        //         return new ListNode(head.next.val);
        //     }
        // }
        ListNode p1 = head;
        ListNode p2 = head;

        for(int i = 0; i < n; i++) {
            p1 = p1.next;
        }

        if(p1 == null) {
            head = head.next;
            return head;
        }

        while(p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        p2.next = p2.next.next;

        return head;
    }
}
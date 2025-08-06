/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        ListNode a1 = headA;
        ListNode a2 = headB;
        while(a1 != null) {
            lengthA++;
            a1 = a1.next;
           
        }

        int lengthB = 0;
        while(a2 != null) {
            lengthB++;
            a2 = a2.next;
        }

        int diff = Math.abs(lengthB - lengthA);
       

        // traverse linkedlist with higher number of nodes at first
        ListNode h1 = (lengthA > lengthB) ? headA : headB;
        ListNode h2 = (lengthB < lengthA) ? headB : headA;

        for(int i = 0; i < diff && diff > 0; i++) {
            h1 = h1.next;
        }

        while(h1 != h2) {
            h1 = h1.next;
            h2 = h2.next;
        }

        return h1;


    }
}
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
    public ListNode doubleIt(ListNode n2) {
        n2 = reverseList(n2);
        ListNode dummy = n2;
        int carry = 0;
        ListNode prev = n2;

        while(n2 != null) {
            int valDoubled = (2 * n2.val);
            n2.val = (valDoubled + carry) % 10;
            carry = (valDoubled + carry) / 10;
            prev = n2;
            n2 = n2.next;
        }
        if(carry != 0) {
            prev.next = new ListNode(carry);
        }
        return(reverseList(dummy));
    }

    public ListNode reverseList(ListNode head) {
        ListNode next;
        ListNode prev = null;

        while(head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
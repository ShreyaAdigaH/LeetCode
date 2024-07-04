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
    public ListNode mergeNodes(ListNode head) {
         ListNode result = head.next;
        ListNode dummy = result;

        while (dummy != null) {
            int sum = 0;
            while (dummy.val != 0) {
                sum += dummy.val;
                dummy = dummy.next;
            }
            result.val = sum;
            dummy = dummy.next;
            result.next = dummy;
            result = result.next;

        }
        return head.next;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.val != temp.next.val) {
                temp = temp.next; // if current node value is not equal to next node value then make next node as
                                  // current node by moving the pointer to next node
            } else {
                temp.next = temp.next.next; // else point the node after the next node as the next node of current node
                                            // but dont update the pointer to that node.
            }
        }
        return head;
    }
}
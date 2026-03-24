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
    public ListNode deleteDuplicates(ListNode head) {
        // Dummy node to handle edge cases
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy; // last node before duplicate sequence
        ListNode curr = head;

        while (curr != null) {

            // Detect duplicate sequence
            if (curr.next != null && curr.val == curr.next.val) {
                
                // Skip all nodes with same value
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }

                // Remove duplicates completely
                prev.next = curr.next;
            } 
            else {
                // No duplicate → move prev
                prev = prev.next;
            }

            // Move curr forward
            curr = curr.next;
        }

        return dummy.next;
    }
}
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
        ListNode dummy = new ListNode(-1);
        dummy.next= head;
        ListNode prev = dummy;
        ListNode curr = head;
        while(curr != null && curr.next != null){
            if(prev == curr){
                return true;
            }
            curr = curr.next.next;
            prev = prev.next;
        }
        return false;
    }
}
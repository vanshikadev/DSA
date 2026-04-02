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
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        if( n == 0 || prev.next == null ){
            return head;
        }
        for(int i = 0;i<n;i++){
            curr = curr.next;
        }
        while(curr != null){
            prev = prev.next;
            curr = curr.next;
        }
        prev.next = prev.next.next;
        return dummy.next;
    }
}
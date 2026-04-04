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
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev= dummy;
        while(prev.next != null){
            ListNode curr = prev.next;
            int value = curr.val;
            if(curr.next != null && curr.next.val == value){
                while(curr != null && curr.val == value){
                    curr = curr.next;
                }
                prev.next = curr;
            }
            else{
                prev=prev.next;
            }
        }
        return dummy.next;
    }
}
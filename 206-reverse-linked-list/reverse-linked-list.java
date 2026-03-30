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
    public ListNode reverseList(ListNode head) {
        if(head == null ){
            return head;   
        }
        ListNode prev = null;
        ListNode middle = head;
        ListNode forward = head.next;

        while(middle.next != null){
            middle.next = prev;
            prev=middle;
            middle = forward;
            forward = forward.next;
        }
        middle.next = prev;
        return middle;

        
    }
}
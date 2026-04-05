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
       ListNode curr = dummy;
       ListNode forw = dummy;
       for(int i=0;i<n;i++){
        forw = forw.next;
       }
       while(forw.next !=null ){
        forw=forw.next;
        curr=curr.next;
       }
       curr.next = curr.next.next;
       return dummy.next;
    }
}
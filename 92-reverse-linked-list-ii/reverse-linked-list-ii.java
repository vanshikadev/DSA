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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = head;
        ListNode curr = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode connect = dummy;
        for(int i = 1 ; i<left; i++ ){
            prev=prev.next;
            connect = connect.next;
        }
        for(int i = 0 ; i<right; i++ ){
            curr=curr.next;
        }
        connect.next = reverse(prev,curr);
        return dummy.next;
    }
    private ListNode reverse(ListNode start, ListNode end){
        ListNode back = end;
        while(start!=end){
            ListNode mid = start.next;
            start.next = back;
            back = start;
            start = mid;
        }
        return back;
    }
}
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode connect = dummy;
        while(true){
        ListNode curr = connect;
        ListNode first = connect.next;
            for(int i=0;i<k;i++){
            curr=curr.next;
            if(curr == null){return dummy.next;}
        }
        curr = curr.next;
        connect.next = reverse (first,curr);
        connect = first;
        }
    }
    private ListNode reverse(ListNode start, ListNode end){
        ListNode back = end;
        while(start != end){
            ListNode mid = start.next;
            start.next = back;
            back = start;
            start = mid;
        }
        return back;
    }
}
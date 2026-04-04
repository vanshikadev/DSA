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
        return reverse(head,null);
    }
    private ListNode reverse(ListNode head, ListNode end){
        ListNode back = end;
        ListNode start = head;

        while(start != null){
            ListNode mid = start.next;
            start.next = back;
            back = start;
            start = mid;
        }
        return back;
    }
}
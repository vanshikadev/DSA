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
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode prev = dummy;
    ListNode curr = dummy;
    for(int i = 0;i<k;i++){
        curr = curr.next;
    }
    ListNode first = curr;
    while(curr != null){
        prev = prev.next;
        curr = curr.next;
    }
    int value = first.val;
    first.val = prev.val;
    prev.val = value;
    return dummy.next;
    }
}
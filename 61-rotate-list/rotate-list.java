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
    public ListNode rotateRight(ListNode head, int k) {
        int size = getSize(head);
        if(k==size || k==0 || head == null || head.next == null ){
            return head;
        }
        if(k>size){
            k = k%size;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = dummy;

        for(int i =0;i<k;i++){
            curr = curr.next;
        }
        while(curr.next != null){
            curr = curr.next;
            prev = prev.next;
        }
        curr.next = dummy.next;
        dummy.next = prev.next;
        prev.next = null;
        return dummy.next;
}
private int getSize(ListNode head){
    int size =0;
    while(head != null){
        head =head.next;
        size = size + 1;
    }
    return size;
}
}
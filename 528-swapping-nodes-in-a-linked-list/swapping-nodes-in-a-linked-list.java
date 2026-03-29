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
        ListNode first = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode second = dummy;
        ListNode curr = head;
        int size = getSize(head);

        if(head == null && head.next == null && k ==0){
            return head.next;
        }

        if(k>size){
            k = k%size;
        }
        for(int i =1 ; i<k; i++){
            first = first.next;
        }
        curr = first;
        while(first != null){
            first = first.next;
            second = second.next;
        }
        int val = curr.val;
        curr.val = second.val;
        second.val = val;
        return dummy.next;
    }

    private int getSize(ListNode head){
        int size = 0;
        while(head != null){
            head = head.next;
            size += 1;
        }
        return size;
    }
}
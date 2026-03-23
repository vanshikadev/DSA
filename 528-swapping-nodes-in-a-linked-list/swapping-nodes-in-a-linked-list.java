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

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = head;
        ListNode second = head;
        ListNode curr1 = head;
        int size = getSize(head);

        if(head == null || head.next == null || k ==0 )
        {
            return head;
        }

       if(k>size){
        k=k%size;
       }
       for(int i =1; i<k;i++){
        first=first.next;
       }
       curr1 = first;

       while(first.next != null){
        first = first.next;
        second=second.next;
       }
       int one = curr1.val;
       curr1.val = second.val;
       second.val = one;
       return head;
    }

    private int getSize(ListNode head){
        int size = 0; 
    while(head != null ){
        size = size +1; 
        head = head.next;
    }
    return size; 
    }
}
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
        if(k == 0 || head == null || head.next == null ) //edge cases
        {
            return head;
        }
        int size = getSize(head);  // O(N) 

        if(k > size){
            k = k%size;
        }
        if(k == size ){ return head; } // same size. 

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode forw = dummy;
        ListNode back = dummy;


        for(int i = 0 ; i< k; i++ ){
            forw = forw.next;       // O(K)
        }
        while (forw.next != null ){
            forw= forw.next;        //O(N-k)
            back = back.next;
        }

        forw.next = dummy.next;
        dummy.next = back.next;
        back.next = null;
        return dummy.next;

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
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
    public ListNode middleNode(ListNode head) {
        int size = getSize(head);
        ListNode curr = head;
        int half = size/2;
        while(half !=0  && head != null && head.next != null){
            curr = curr.next;
            half -= 1;
        } 

        return curr;
    }
    private int getSize(ListNode head){
        int size = 0;
        while (head != null){
            size += 1;
            head = head.next;
        }
        return size;
    }
}
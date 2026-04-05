/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode forw = head;
        ListNode prev = head;
        while(forw != null && forw.next != null){
            forw = forw.next.next;
            prev=prev.next;
            if(forw == prev){
                return true;
            }
        }
        return false;
    }
}
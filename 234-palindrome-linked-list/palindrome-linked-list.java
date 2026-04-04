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
    public boolean isPalindrome(ListNode head) {
        //handling edge case
        if(head == null || head.next == null){
            return true;
        }

        ListNode first = head;
        ListNode second = head;

        //finding middle 
        while (second != null && second.next != null){
            first = first.next;
            second = second.next.next;
        }
        if(second != null){
            first = first.next;
        }

        //reversing in place 

        ListNode back = null;
        while(first != null){
            ListNode mid = first.next;
            first.next = back;
            back = first;
            first = mid;
        }

        //comparing
        ListNode curr = head;
        while(back != null){
            if(curr.val != back.val){
                return false;
            }
            curr=curr.next;
            back = back.next;
        }
        return true;
    }
}
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy; 

        ListNode first = list1;
        ListNode second = list2;

        while(first != null && second != null){
            if(first.val <= second.val){
                curr.next = first;
                first = first.next;
                curr = curr.next;
            }
            else{
                curr.next = second;
                second = second.next;
                curr = curr.next;
            }
        }
        curr.next = first==null? second : first;
        return dummy.next;
}
}
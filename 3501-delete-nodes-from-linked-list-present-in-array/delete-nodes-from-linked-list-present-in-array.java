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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums)
        {
            set.add(num);   //time complexity - O(N) where n is the size of array
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
//time complexity - iterate for k times, where k is the size of linked list
        while(curr.next != null){
            if(set.contains(curr.next.val))
            {
                curr.next = curr.next.next;
            }
            else
            {
                curr = curr.next;
            }

        }

        return dummy.next;
        

    }
}
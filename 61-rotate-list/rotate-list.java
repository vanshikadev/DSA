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

        ListNode dummy = new ListNode(-1); 
        dummy.next = head;
        ListNode curr = dummy;
        ListNode prev = dummy;
        int n = getSize(head);  // O(N)
        if(k == n || k == 0 || n ==0)
        {
            return head;
        }
        else
        {
            if(k>n)
        {
            k = k%n;
        }

        for (int i = 0; i < k; i++)//O(k)
        {
            while(curr.next!=null)   // O(N)
            {
                prev = curr;
                curr=curr.next;
            }

            curr.next = head;
            dummy.next = curr;
            head = curr;
            curr = dummy;
            prev.next= null;

        }

        return dummy.next;
        }
        
    }
    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}
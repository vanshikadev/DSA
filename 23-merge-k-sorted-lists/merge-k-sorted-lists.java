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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)-> a.val-b.val);
        for( ListNode node : lists){
            if(node != null){
                 minHeap.offer(node);
            }
        }
        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            curr.next = node;
            curr = curr.next;
            if(node.next != null){
                 minHeap.offer(node.next);
            }
            curr.next = null;
        }
        return dummy.next;
    }
}
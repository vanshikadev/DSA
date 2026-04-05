public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        //detect cycle
        ListNode forw = head;
        ListNode prev = head;
        ListNode curr = null;
        while(forw != null && forw.next != null){
            forw = forw.next.next;
            prev=prev.next;
            if(forw == prev){
                curr = prev;
                prev = head;
                break;
            }
        }
        while(forw != null && forw.next != null){
            if(curr == prev){
                return curr;
            }
            curr = curr.next;
            prev=prev.next;
        }
        return null;
    }
}
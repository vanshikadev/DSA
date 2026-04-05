class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        //dividing
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;

        //further divide
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        //merging
        return merge(left,right);
    }
    private ListNode merge(ListNode left,ListNode right){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(left != null && right != null){
            if(left.val >= right.val){
                curr.next = right;
                curr = curr.next;
                right=right.next;
            }
            else{
                curr.next = left;
                curr = curr.next;
                left=left.next;
            }
        }
        curr.next = left == null ? right:left;
        return dummy.next;
    }
}
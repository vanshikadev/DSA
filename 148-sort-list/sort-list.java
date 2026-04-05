class Solution {
    public ListNode sortList(ListNode head) {
        // BASE CASE → constant work
        if (head == null || head.next == null) return head;

        // 🔽 DIVIDE STEP (find middle)
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) { // O(n)
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null; // split list into 2 halves

        // 🔁 RECURSION (divide further)
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        // 🔼 MERGE STEP
        return merge(left, right); // O(n)
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) { // O(n)
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 != null) curr.next = l1;
        if (l2 != null) curr.next = l2;

        return dummy.next;
    }
}
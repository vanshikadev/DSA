/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }

        // adding copied nodes in between
        Node curr = head;
        while(curr != null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr= copy.next;
        }

        //adding random pointers
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;    
        }

        //extracting
        curr  = head;
        Node dummy = new Node(-1);
        Node copy = dummy;

        while(curr != null){
            copy.next = curr.next;
            copy= copy.next;
            curr.next = curr.next.next;
            curr=curr.next;
        }
        return dummy.next;
    }
}
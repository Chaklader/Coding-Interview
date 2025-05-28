import DS.ListNode;

/*
    // Definition of ListNode:
    class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) {
            this(val);
            this.next = next;
        }
    }
 */


public class LinkedListReversal {
    public static ListNode linkedListReversal(ListNode head) {
        ListNode currNode = head;
        ListNode prevNode = null;
        // Reverse the direction of each node's pointer until 'currNode'
        // is null.
        while (currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        // 'prevNode' will be pointing at the head of the reversed linked
        // list.
        return prevNode;
    }
}

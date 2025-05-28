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


public class LinkedListReversalRecursive {
    public static ListNode linkedListReversalRecursive(ListNode head) {
        // Base cases.
        if (head == null || head.next == null) return head;
        else {
            // Recursively reverse the sublist starting from the next node.
            ListNode newHead = linkedListReversalRecursive(head.next);
            // Connect the reversed linked list to the head node to fully
            // reverse the entire linked list.
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }
}

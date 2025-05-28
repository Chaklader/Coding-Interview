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


public class LinkedListMidpoint {
    public ListNode linkedListMidpoint(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        // When the fast pointer reaches the end of the list, the slow
        // pointer will be at the midpoint of the linked list.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

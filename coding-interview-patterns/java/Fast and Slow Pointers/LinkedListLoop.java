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


public class LinkedListLoop {
    public boolean linkedListLoop(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        // Check both 'fast' and 'fast.next' to avoid null pointer
        // exceptions when we perform 'fast.next' and 'fast.next.next'.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;
        }
        return false;
    }
}

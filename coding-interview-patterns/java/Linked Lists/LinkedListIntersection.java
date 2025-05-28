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


public class LinkedListIntersection {
    public static ListNode linkedListIntersection(ListNode headA, ListNode headB) {
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        // Traverse through list A with 'ptrA' and list B with 'ptrB'
        // until they meet.
        while (ptrA != ptrB) {
            // Traverse list A -> list B by first traversing 'ptrA' and
            // then, upon reaching the end of list A, continue the
            // traversal from the head of list B.
            ptrA = ptrA == null ? headB : ptrA.next;
            // Simultaneously, traverse list B -> list A.
            ptrB = ptrB == null ? headA : ptrB.next;
        }
        // At this point, 'ptrA' and 'ptrB' either point to the
        // intersection node or both are null if the lists do not
        // intersect. Return either pointer.
        return ptrA;
    }
}

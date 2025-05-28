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


public class SortLinkedList {
    public ListNode sortLinkedList(ListNode head) {
        // If the linked list is empty or has only one element, it's already
        // sorted.
        if (head == null || head.next == null) return head;
        // Split the linked list into halves using the fast and slow pointer
        // technique.
        ListNode secondHead = splitList(head);
        // Recursively sort both halves.
        ListNode firstHalfSorted = sortLinkedList(head);
        ListNode secondHalfSorted = sortLinkedList(secondHead);
        // Merge the sorted sublists.
        return merge(firstHalfSorted, secondHalfSorted);
    }

    private ListNode splitList(ListNode head) {
        ListNode slow;
        ListNode fast;
        slow = fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHead = slow.next;
        slow.next = null;
        return secondHead;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        // This pointer will be used to append nodes to the tail of the 
        // merged linked list.
        ListNode tail = dummy;
        // Continually append the node with the smaller value from each 
        // linked list to the merged linked list until one of the linked 
        // lists has no more nodes to merge.
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        // One of the two linked lists could still have nodes remaining.
        // Attach those nodes to the end of the merged linked list.
        tail.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
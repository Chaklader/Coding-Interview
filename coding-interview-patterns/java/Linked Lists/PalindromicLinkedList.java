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


public class PalindromicLinkedList {
    public static boolean palindromicLinkedList(ListNode head) {
        // Find the middle of the linked list and then reverse the second half of the
        // linked list starting at this midpoint.
        ListNode mid = findMiddle(head);
        ListNode secondHead = reverseList(mid);
        // Compare the first half and the reversed second half of the list
        ListNode ptr1 = head;
        ListNode ptr2 = secondHead;
        boolean result = true;
        while (ptr2 != null) {
            if (ptr1.val != ptr2.val) {
                result = false;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return result;
    }

    // From the 'Reverse Linked List' problem.
    private static ListNode reverseList(ListNode head) {
        ListNode currNode = head;
        ListNode prevNode = null;
        while (currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }

    // From the 'Linked List Midpoint' problem.
    private static ListNode findMiddle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
}

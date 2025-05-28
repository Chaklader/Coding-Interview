import java.util.HashSet;
import java.util.Set;

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


public class LinkedListLoopNaive {
    public boolean linkedListLoopNaive(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            // Cycle detected if the current node has already been visited.
            if (visited.contains(curr)) return true;
            visited.add(curr);
            curr = curr.next;
        }
        return false;
    }
}

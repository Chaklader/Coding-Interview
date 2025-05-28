import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import DS.ListNode;

/*
    // Definition of ListNode:
    class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val) { this.val = val; }
    }
 */

public class CombineSortedLinkedLists {
    public ListNode combineSortedLinkedLists(List<ListNode> lists) {
        // Define a custom comparator for 'ListNode', enabling the min-heap 
        // to prioritize nodes with smaller values.
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode self, ListNode other) {
                return Integer.compare(self.val, other.val);
            }
        });
        // Push the head of each linked list into the heap.
        for (ListNode head : lists) {
            if (head != null) {
                heap.offer(head);
            }
        }
        // Set a dummy node to point to the head of the output linked list.
        ListNode dummy = new ListNode(-1);
        // Create a pointer to iterate through the combined linked list as 
        // we add nodes to it.
        ListNode curr = dummy;
        while (!heap.isEmpty()) {
            // Pop the node with the smallest value from the heap and add it 
            // to the output linked list.
            ListNode smallestNode = heap.poll();
            curr.next = smallestNode;
            curr = curr.next;
            // Push the popped node's subsequent node to the heap.
            if (smallestNode.next != null) {
                heap.offer(smallestNode.next);
            }
        }
        return dummy.next;
    }
}

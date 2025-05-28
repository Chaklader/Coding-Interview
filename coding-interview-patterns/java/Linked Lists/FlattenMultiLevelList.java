import DS.MultiLevelListNode;

/*
    // Definition of MultiLevelListNode:
    class MultiLevelListNode {
        public int val;
        public MultiLevelListNode next;
        public MultiLevelListNode child;
        public MultiLevelListNode(int val) { this.val = val; }
        public MultiLevelListNode(int val, MultiLevelListNode next, MultiLevelListNode child) {
            this(val);
            this.next = next;
            this.child = child;
        }
    }
 */


public class FlattenMultiLevelList {
    public static MultiLevelListNode flattenMultiLevelList(MultiLevelListNode head) {
        if (head == null) {
            return null;
        }
        MultiLevelListNode tail = head;
        // Find the tail of the linked list at the first level.
        while (tail.next != null) {
            tail = tail.next;
        }
        MultiLevelListNode curr = head;
        // Process each node at the current level. If a node has a child linked list,
        // append it to the tail and then update the tail to the end of the extended
        // linked list. Continue until all nodes at the current level are processed.
        while (curr != null) {
            if (curr.child != null) {
                tail.next = curr.child;
                // Disconnect the child linked list from the current node.
                curr.child = null;
                while (tail.next != null) {
                    tail = tail.next;
                }
            }
            curr = curr.next;
        }
        return head;
    }
}

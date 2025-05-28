import ds.MultiLevelListNode

/*
    Definition for a MultiLevelListNode:
    data class MultiLevelListNode(
            var value: Int,
            var next: MultiLevelListNode? = null,
            var child: MultiLevelListNode? = null
    )
*/

fun flattenMultiLevelList(head: MultiLevelListNode?): MultiLevelListNode? {
    if (head == null) {
        return null
    }
    var tail = head
    // Find the tail of the linked list at the first level.
    while (tail?.next != null) {
        tail = tail.next
    }
    var curr = head
    // Process each node at the current level. If a node has a child linked list,
    // append it to the tail and then update the tail to the end of the extended
    // linked list. Continue until all nodes at the current level are processed.
    while (curr != null) {
        if (curr.child != null) {
            tail?.next = curr.child
            // Disconnect the child linked list from the current node.
            curr.child = null
            while (tail?.next != null) {
                tail = tail.next
            }
        }
        curr = curr.next
    }
    return head
}

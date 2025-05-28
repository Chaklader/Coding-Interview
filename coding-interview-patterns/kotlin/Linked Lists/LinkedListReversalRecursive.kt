import ds.ListNode

/*
    Definition of ListNode:
    data class ListNode(var value: Int = 0, var next: ListNode? = null)
*/

fun linkedListReversalRecursive(head: ListNode?): ListNode? {
    // Base cases.
    if (head == null || head.next == null) {
        return head
    }
    // Recursively reverse the sublist starting from the next node.
    val newHead = linkedListReversalRecursive(head.next)
    // Connect the reversed linked list to the head node to fully
    // reverse the entire linked list.
    head.next!!.next = head
    head.next = null
    return newHead
}

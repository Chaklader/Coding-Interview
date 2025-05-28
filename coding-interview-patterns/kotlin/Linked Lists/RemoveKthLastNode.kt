import ds.ListNode

/*
    Definition of ListNode:
    data class ListNode(var value: Int = 0, var next: ListNode? = null)
*/

fun removeKthLastNode(head: ListNode?, k: Int): ListNode? {
    // A dummy node to ensure there's a node before 'head' in case we
    // need to remove the head node.
    val dummy = ListNode(-1)
    dummy.next = head
    var trailer = dummy
    var leader = dummy
    // Advance 'leader' k steps ahead.
    repeat(k) {
        // If k is larger than the length of the linked list, no node
        // needs to be removed.
        leader = leader.next ?: return head
    }
    // Move 'leader' to the end of the linked list, keeping 'trailer'
    // k nodes behind.
    while (leader.next != null) {
        leader = leader.next!!
        trailer = trailer.next!!
    }
    // Remove the kth node from the end.
    trailer.next = trailer.next?.next
    return dummy.next
}

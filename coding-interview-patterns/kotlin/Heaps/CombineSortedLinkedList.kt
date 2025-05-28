import java.util.PriorityQueue
import ds.ListNode

/*
    Definition of ListNode:
    data class ListNode(var value: Int, var next: ListNode? = null)
*/

fun combineSortedLinkedLists(lists: List<ListNode?>): ListNode? {
    // Define a custom comparator for 'ListNode', enabling the min-heap
    // to prioritize nodes with smaller values.
    val heap = PriorityQueue<ListNode> { a, b -> a.value - b.value }
    // Push the head of each linked list into the heap.
    for (head in lists) {
        if (head != null) {
            heap.add(head)
        }
    }
    // Set a dummy node to point to the head of the output linked list.
    val dummy = ListNode(-1)
    // Create a pointer to iterate through the combined linked list as
    // we add nodes to it.
    var curr = dummy
    while (heap.isNotEmpty()) {
        // Pop the node with the smallest value from the heap and add it
        // to the output linked list.
        val smallestNode = heap.poll()
        curr.next = smallestNode
        curr = curr.next!!
        // Push the popped node's subsequent node to the heap.
        if (smallestNode.next != null) {
            heap.add(smallestNode.next)
        }
    }
    return dummy.next
}

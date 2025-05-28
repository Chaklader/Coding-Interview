/*
    Definition of ListNode:
    data class ListNode(var value: Int, var next: ListNode? = null)
*/

fun linkedListLoopNaive(head: ListNode?): Boolean {
    val visited = mutableSetOf<ListNode>()
    var curr = head
    while (curr != null) {
        // Cycle detected if the current node has already been visited.
        if (visited.contains(curr)) {
            return true
        }
        visited.add(curr)
        curr = curr.next
    }
    return false
}
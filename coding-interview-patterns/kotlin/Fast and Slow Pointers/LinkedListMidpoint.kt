/*
    Definition of ListNode:
    data class ListNode(var value: Int, var next: ListNode? = null)
*/

fun linkedListMidpoint(head: ListNode?): ListNode? {
    var slow = head
    var fast = head
    // When the fast pointer reaches the end of the list, the slow
    // pointer will be at the midpoint of the linked list.
    while (fast != null && fast.next != null) {
        slow = slow!!.next
        fast = fast.next!!.next
    }
    return slow
}
/*
    Definition of ListNode:
    data class ListNode(var value: Int, var next: ListNode? = null)
*/

fun linkedListLoop(head: ListNode?): Boolean {
    var slow = head
    var fast = head
    // Check both 'fast' and 'fast.next' to avoid null pointer
    // exceptions when we perform 'fast.next' and 'fast.next.next'.
    while (fast != null && fast.next != null) {
        slow = slow!!.next
        fast = fast.next!!.next
        if (fast == slow) {
            return true
        }
    }
    return false
}
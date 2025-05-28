import ds.ListNode

/*
    Definition of ListNode:
    data class ListNode(var value: Int = 0, var next: ListNode? = null)
*/

fun palindromicLinkedList(head: ListNode?): Boolean {
    // Find the middle of the linked list and then reverse the second half of the
    // linked list starting at this midpoint.
    val mid = findMiddle(head)
    val secondHead = reverseList(mid)
    // Compare the first half and the reversed second half of the list
    var ptr1 = head
    var ptr2 = secondHead
    var res = true
    while (ptr2 != null) {
        if (ptr1?.value != ptr2?.value) {
            res = false
        }
        ptr1 = ptr1?.next
        ptr2 = ptr2?.next
    }
    return res
}

// From the 'Reverse Linked List' problem.
fun reverseList(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var curr = head
    while (curr != null) {
        val next = curr.next
        curr.next = prev
        prev = curr
        curr = next
    }
    return prev
}

// From the 'Linked List Midpoint' problem.
fun findMiddle(head: ListNode?): ListNode? {
    var slow = head
    var fast = head
    while (fast != null && fast.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }
    return slow
}
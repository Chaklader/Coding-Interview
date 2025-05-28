import ds.ListNode

/*
    Definition of ListNode:
    data class ListNode(var value: Int = 0, var next: ListNode? = null)
*/

fun sortLinkedList(head: ListNode?): ListNode? {
    // If the linked list is empty or has only one element, it's already
    // sorted.
    if (head == null || head.next == null) {
        return head
    }
    // Split the linked list into halves using the fast and slow pointer
    // technique.
    val secondHead = splitList(head)
    // Recursively sort both halves.
    val firstHalfSorted = sortLinkedList(head)
    val secondHalfSorted = sortLinkedList(secondHead)
    // Merge the sorted sublists.
    return merge(firstHalfSorted, secondHalfSorted)
}

fun splitList(head: ListNode): ListNode {
    var slow = head
    var fast = head
    while (fast.next != null && fast.next!!.next != null) {
        slow = slow.next!!
        fast = fast.next!!.next!!
    }
    val secondHead = slow.next
    slow.next = null
    return secondHead!!
}

fun merge(l1: ListNode?, l2: ListNode?): ListNode? {
    val dummy = ListNode()
    // This pointer will be used to append nodes to the tail of the
    // merged linked list.
    var tail = dummy
    var list1 = l1
    var list2 = l2
    // Continually append the node with the smaller value from each
    // linked list to the merged linked list until one of the linked
    // lists has no more nodes to merge.
    while (list1 != null && list2 != null) {
        if (list1.value < list2.value) {
            tail.next = list1
            list1 = list1.next
        } else {
            tail.next = list2
            list2 = list2.next
        }
        tail = tail.next!!
    }
    // One of the two linked lists could still have nodes remaining.
    // Attach those nodes to the end of the merged linked list.
    tail.next = list1 ?: list2
    return dummy.next
}

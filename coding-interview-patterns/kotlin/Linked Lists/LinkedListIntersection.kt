import ds.ListNode

/*
    Definition of ListNode:
    data class ListNode(var value: Int = 0, var next: ListNode? = null)
*/

fun linkedListIntersection(headA: ListNode?, headB: ListNode?): ListNode? {
    var ptrA = headA
    var ptrB = headB
    // Traverse through list A with 'ptrA' and list B with 'ptrB'
    // until they meet.
    while (ptrA != ptrB) {
        // Traverse list A -> list B by first traversing 'ptrA' and
        // then, upon reaching the end of list A, continue the
        // traversal from the head of list B.
        ptrA = if (ptrA != null) ptrA.next else headB
        // Simultaneously, traverse list B -> list A.
        ptrB = if (ptrB != null) ptrB.next else headA
    }
    // At this point, 'ptrA' and 'ptrB' either point to the
    // intersection node or both are null if the lists do not
    // intersect. Return either pointer.
    return ptrA
}
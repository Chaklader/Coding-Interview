import ds.ListNode

/*
    Definition of ListNode:
    data class ListNode(var value: Int = 0, var next: ListNode? = null)
*/

fun linkedListReversal(head: ListNode?): ListNode? {
    var currNode = head
    var prevNode: ListNode? = null
    // Reverse the direction of each node's pointer until 'currNode' 
    // is null.
    while (currNode != null) {
        val nextNode = currNode.next
        currNode.next = prevNode
        prevNode = currNode
        currNode = nextNode
    }
    // 'prevNode' will be pointing at the head of the reversed linked 
    // list.
    return prevNode
}
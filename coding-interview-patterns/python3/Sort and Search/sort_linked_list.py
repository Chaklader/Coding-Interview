from ds import ListNode

"""
Definition of ListNode:
class ListNode:
    def __init__(self, val=None, next=None):
        self.val = val
        self.next = next
"""


def sort_linked_list(head: ListNode) -> ListNode:
    # If the linked list is empty or has only one element, it's already
    # sorted.
    if not head or not head.next:
        return head
    # Split the linked list into halves using the fast and slow pointer
    # technique.
    second_head = split_list(head) 
    # Recursively sort both halves.
    first_half_sorted = sort_linked_list(head)
    second_half_sorted = sort_linked_list(second_head)
    # Merge the sorted sublists.
    return merge(first_half_sorted, second_half_sorted)

def split_list(head: ListNode) -> ListNode:
    slow = fast = head
    while fast.next and fast.next.next:
        slow = slow.next
        fast = fast.next.next
    second_head = slow.next
    slow.next = None
    return second_head

def merge(l1: ListNode, l2: ListNode) -> ListNode:
    dummy = ListNode(0)
    # This pointer will be used to append nodes to the tail of the 
    # merged linked list.
    tail = dummy
    # Continually append the node with the smaller value from each 
    # linked list to the merged linked list until one of the linked 
    # lists has no more nodes to merge.
    while l1 and l2:
        if l1.val < l2.val:
            tail.next = l1
            l1 = l1.next
        else:
            tail.next = l2
            l2 = l2.next
        tail = tail.next
    # One of the two linked lists could still have nodes remaining.
    # Attach those nodes to the end of the merged linked list.
    tail.next = l1 or l2
    return dummy.next

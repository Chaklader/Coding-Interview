from ds import ListNode

"""
Definition of ListNode:
class ListNode:
    def __init__(self, val=None, next=None):
        self.val = val
        self.next = next
"""


def linked_list_reversal_recursive(head: ListNode) -> ListNode:
    # Base cases.
    if (not head) or (not head.next):
        return head
    # Recursively reverse the sublist starting from the next node.
    new_head = linked_list_reversal_recursive(head.next)
    # Connect the reversed linked list to the head node to fully
    # reverse the entire linked list.
    head.next.next = head
    head.next = None
    return new_head

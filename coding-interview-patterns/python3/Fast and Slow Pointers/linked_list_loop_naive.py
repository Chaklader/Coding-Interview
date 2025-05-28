from ds import ListNode

"""
Definition of ListNode:
class ListNode:
    def __init__(self, val=None, next=None):
        self.val = val
        self.next = next
"""


def linked_list_loop_naive(head: ListNode) -> bool:
    visited = set()  
    curr = head
    while curr:  
        # Cycle detected if the current node has already been visited.
        if curr in visited:
            return True  
        visited.add(curr)  
        curr = curr.next
    return False  

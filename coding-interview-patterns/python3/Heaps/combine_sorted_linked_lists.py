import heapq
from ds import ListNode
from typing import List

"""
Definition of ListNode:
class ListNode:
    def __init__(self, val=None, next=None):
        self.val = val
        self.next = next
"""


def combine_sorted_linked_lists(lists: List[ListNode]) -> ListNode:
    # Define a custom comparator for 'ListNode', enabling the min-heap 
    # to prioritize nodes with smaller values.
    ListNode.__lt__ = lambda self, other: self.val < other.val
    heap = []
    # Push the head of each linked list into the heap.
    for head in lists:
        if head:
            heapq.heappush(heap, head)
    # Set a dummy node to point to the head of the output linked list.
    dummy = ListNode(-1)
    # Create a pointer to iterate through the combined linked list as 
    # we add nodes to it.
    curr = dummy
    while heap:
        # Pop the node with the smallest value from the heap and add it 
        # to the output linked list.
        smallest_node = heapq.heappop(heap)
        curr.next = smallest_node
        curr = curr.next
        # Push the popped node's subsequent node to the heap.
        if smallest_node.next:
            heapq.heappush(heap, smallest_node.next)
    return dummy.next

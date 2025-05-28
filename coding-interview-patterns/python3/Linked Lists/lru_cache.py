class DoublyLinkedListNode:
    def __init__(self, key: int, val: int):
        self.key = key
        self.val = val
        self.next = self.prev = None


class LRUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        # A hash map that maps keys to nodes.
        self.hashmap = {}
        # Initialize the head and tail dummy nodes and connect them to 
        # each other to establish a basic two-node doubly linked list.
        self.head = DoublyLinkedListNode(-1, -1)
        self.tail = DoublyLinkedListNode(-1, -1)
        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, key: int) -> int:
        if key not in self.hashmap:
            return -1
        # To make this key the most recently used, remove its node and 
        # re-add it to the tail of the linked list.
        self.remove_node(self.hashmap[key])
        self.add_to_tail(self.hashmap[key])
        return self.hashmap[key].val

    def put(self, key: int, value: int) -> None:
        # If a node with this key already exists, remove it from the 
        # linked list.
        if key in self.hashmap:
            self.remove_node(self.hashmap[key])
        node = DoublyLinkedListNode(key, value)
        self.hashmap[key] = node
        # Remove the least recently used node from the cache if adding 
        # this new node will result in an overflow.
        if len(self.hashmap) > self.capacity:
            del self.hashmap[self.head.next.key]
            self.remove_node(self.head.next)
        self.add_to_tail(node)

    def add_to_tail(self, node: DoublyLinkedListNode) -> None:
        prev_node = self.tail.prev
        node.prev = prev_node
        node.next = self.tail
        prev_node.next = node
        self.tail.prev = node

    def remove_node(self, node: DoublyLinkedListNode) -> None:
        node.prev.next = node.next
        node.next.prev = node.prev
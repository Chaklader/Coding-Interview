data class DoublyLinkedListNode(val key: Int, val value: Int) {
    var next: DoublyLinkedListNode? = null
    var prev: DoublyLinkedListNode? = null
}

class LRUCache {

    private val capacity: Int
    private val hashmap: MutableMap<Int, DoublyLinkedListNode>
    private val head: DoublyLinkedListNode
    private val tail: DoublyLinkedListNode

    constructor(capacity: Int) {
        this.capacity = capacity
        // A hash map that maps keys to nodes.
        this.hashmap = mutableMapOf()
        // Initialize the head and tail dummy nodes and connect them to
        // each other to establish a basic two-node doubly linked list.
        this.head = DoublyLinkedListNode(-1, -1)
        this.tail = DoublyLinkedListNode(-1, -1)
        this.head.next = this.tail
        this.tail.prev = this.head
    }

    fun get(key: Int): Int {
        if (key !in hashmap) {
            return -1
        }
        // To make this key the most recently used, remove its node and
        // re-add it to the tail of the linked list.
        val node = hashmap[key]!!
        removeNode(node)
        addToTail(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        // If a node with this key already exists, remove it from the
        // linked list.
        if (key in hashmap) {
            removeNode(hashmap[key]!!)
        }
        val node = DoublyLinkedListNode(key, value)
        hashmap[key] = node
        // Remove the least recently used node from the cache if adding
        // this new node will result in an overflow.
        if (hashmap.size > capacity) {
            hashmap.remove(head.next!!.key)
            removeNode(head.next!!)
        }
        addToTail(node)
    }

    private fun addToTail(node: DoublyLinkedListNode) {
        val prevNode = tail.prev
        node.prev = prevNode
        node.next = tail
        prevNode!!.next = node
        tail.prev = node
    }

    private fun removeNode(node: DoublyLinkedListNode) {
        node.prev!!.next = node.next
        node.next!!.prev = node.prev
    }
}

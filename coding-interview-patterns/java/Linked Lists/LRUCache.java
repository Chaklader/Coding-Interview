import java.util.HashMap;

class DoublyLinkedListNode {
    public int key;
    public int val;
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;
    public DoublyLinkedListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}


public class LRUCache {
    public int capacity;
    public HashMap<Integer, DoublyLinkedListNode> cache;
    public DoublyLinkedListNode head;
    public DoublyLinkedListNode tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        // A hash map that maps keys to nodes.
        cache = new HashMap<>();
        // Initialize the head and tail dummy nodes and connect them to
        // each other to establish a basic two-node doubly linked list.
        head = new DoublyLinkedListNode(-1, -1);
        tail = new DoublyLinkedListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        else {
            // To make this key the most recently used, remove its node and
            // re-add it to the tail of the linked list.
            remove(cache.get(key));
            addToTail(cache.get(key));
            return cache.get(key).val;
        }
    }

    public void put(int key, int val) {
        // If a node with this key already exists, remove it from the
        // linked list.
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        DoublyLinkedListNode node = new DoublyLinkedListNode(key, val);
        cache.put(key, node);
        // Remove the least recently used node from the cache if adding
        // this new node will result in an overflow.
        if (cache.size() > capacity) {
            cache.remove(head.next.key);
            remove(head.next);
        }
        addToTail(node);
    }

    private void addToTail(DoublyLinkedListNode node) {
        DoublyLinkedListNode prevNode = tail.prev;
        node.prev = prevNode;
        node.next = tail;
        prevNode.next = node;
        tail.prev = node;
    }

    private void remove(DoublyLinkedListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

}

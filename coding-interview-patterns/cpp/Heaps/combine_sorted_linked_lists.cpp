#include <vector>
#include <queue>
#include "ds/ListNode.h"
using ds::ListNode;

/**
 * Definition of ListNode:
 * struct ListNode {
 *     int val;
 *     ListNode* next;
 *     ListNode(int val = 0, ListNode* next = nullptr) : val(val), next(next) {}
 * };
 */

ListNode* combineSortedLinkedLists(std::vector<ListNode*>& lists) {
    // Min-heap (priority queue) storing (node value, node pointer) pairs.
    // std::pair's built-in comparison ensures the heap is ordered by value.
    typedef std::pair<int, ListNode*> NodePair;
    std::priority_queue<NodePair, std::vector<NodePair>, std::greater<NodePair>> heap;
    // Push the head of each linked list into the heap.
    for (ListNode* head : lists) {
        if (head) {
            heap.push(std::make_pair(head->val, head));
        }
    }
    // Set a dummy node to point to the head of the output linked list.
    ListNode dummy(-1);
    // Create a pointer to iterate through the combined linked list as 
    // we add nodes to it.
    ListNode* curr = &dummy;
    while (!heap.empty()) {
        // Pop the node with the smallest value from the heap and add it 
        // to the output linked list.
        NodePair smallestNodePair = heap.top();
        heap.pop();
        ListNode* smallestNode = smallestNodePair.second;
        curr->next = smallestNode;
        curr = curr->next;
        // Push the popped node's subsequent node to the heap.
        if (smallestNode->next) {
            heap.push(std::make_pair(smallestNode->next->val, smallestNode->next));
        }
    }
    return dummy.next;
}
#include <unordered_set>
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

bool linkedListLoopNaive(ListNode* head) {
    std::unordered_set<ListNode*> visited;
    ListNode* curr = head;
    while (curr) {
        // Cycle detected if the current node has already been visited.
        if (visited.find(curr) != visited.end()) {
            return true;
        }
        visited.insert(curr);
        curr = curr->next;
    }
    return false;
}
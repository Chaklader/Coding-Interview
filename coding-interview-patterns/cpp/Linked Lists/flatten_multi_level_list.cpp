#include "ds/MultiLevelListNode.h"
using ds::MultiLevelListNode;

/**
 * Definition of MultiLevelListNode:
 * class MultiLevelListNode {
 * public:
 *     int val;
 *     MultiLevelListNode* next;
 *     MultiLevelListNode* child;
 *     MultiLevelListNode(int val = 0, MultiLevelListNode* next = nullptr, MultiLevelListNode* child = nullptr)
 *         : val(val), next(next), child(child) {}
 * };
 */

MultiLevelListNode* flattenMultiLevelList(MultiLevelListNode* head) {
    if (!head) {
        return nullptr;
    }
    MultiLevelListNode* tail = head;
    // Find the tail of the linked list at the first level.
    while (tail->next) {
        tail = tail->next;
    }
    MultiLevelListNode* curr = head;
    // Process each node at the current level. If a node has a child linked list,
    // append it to the tail and then update the tail to the end of the extended 
    // linked list. Continue until all nodes at the current level are processed.
    while (curr) {
        if (curr->child) {
            tail->next = curr->child;
            // Disconnect the child linked list from the current node.
            curr->child = nullptr;
            while (tail->next) {
                tail = tail->next;
            }
        }
        curr = curr->next;
    }
    return head;
}
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

ListNode* linkedListReversalRecursive(ListNode* head) {
    // Base cases.
    if (head == nullptr || head->next == nullptr) {
        return head;
    }
    // Recursively reverse the sublist starting from the next node.
    ListNode* newHead = linkedListReversalRecursive(head->next);
    // Connect the reversed linked list to the head node to fully
    // reverse the entire linked list.
    head->next->next = head; 
    head->next = nullptr;   
    return newHead;
}
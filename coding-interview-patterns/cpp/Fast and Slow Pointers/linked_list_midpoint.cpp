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

ListNode* linkedListMidpoint(ListNode* head) {
    ListNode* slow = head;
    ListNode* fast = head;
    // When the fast pointer reaches the end of the list, the slow
    // pointer will be at the midpoint of the linked list.
    while (fast != nullptr && fast->next != nullptr) {
        slow = slow->next;
        fast = fast->next->next;
    }
    return slow;
}
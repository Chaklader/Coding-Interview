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

bool linkedListLoop(ListNode* head) {
    ListNode* slow = head;
    ListNode* fast = head;
    // Check both 'fast' and 'fast->next' to avoid null pointer
    // exceptions when we perform 'fast->next' and 'fast->next->next'.
    while (fast != nullptr && fast->next != nullptr) {
        slow = slow->next;
        fast = fast->next->next;
        if (fast == slow) {
            return true;
        }
    }
    return false;
}
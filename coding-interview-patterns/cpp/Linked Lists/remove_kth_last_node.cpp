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

ListNode* removeKthLastNode(ListNode* head, int k) {
    // A dummy node to ensure there's a node before 'head' in case we
    // need to remove the head node.
    ListNode dummy(-1);
    dummy.next = head;
    ListNode* trailer = &dummy;
    ListNode* leader = &dummy;
    // Advance 'leader' k steps ahead.  
    for (int i = 0; i < k; i++) {
        leader = leader->next;
        // If k is larger than the length of the linked list, no node 
        // needs to be removed.
        if (leader == nullptr) {
            return head;
        }
    }
    // Move 'leader' to the end of the linked list, keeping 'trailer'
    // k nodes behind.
    while (leader->next != nullptr) {
        leader = leader->next;
        trailer = trailer->next;
    }
    // Remove the kth node from the end.
    trailer->next = trailer->next->next;
    return dummy.next;
}
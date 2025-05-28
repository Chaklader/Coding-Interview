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

ListNode* linkedListIntersection(ListNode* head_A, ListNode* head_B) {
    ListNode* ptr_A = head_A;
    ListNode* ptr_B = head_B;
    // Traverse through list A with 'ptr_A' and list B with 'ptr_B' 
    // until they meet.
    while (ptr_A != ptr_B) {
        // Traverse list A -> list B by first traversing 'ptr_A' and 
        // then, upon reaching the end of list A, continue the 
        // traversal from the head of list B.
        if (ptr_A != nullptr) {
            ptr_A = ptr_A->next;
        } else {
            ptr_A = head_B;
        }
        // Simultaneously, traverse list B -> list A.
        if (ptr_B != nullptr) {
            ptr_B = ptr_B->next;
        } else {
            ptr_B = head_A;
        }
    }
    // At this point, 'ptr_A' and 'ptr_B' either point to the 
    // intersection node or both are null if the lists do not 
    // intersect. Return either pointer.
    return ptr_A;  
}
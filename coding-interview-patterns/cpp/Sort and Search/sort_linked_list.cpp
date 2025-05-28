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

ListNode* sortLinkedList(ListNode* head) {
    // If the linked list is empty or has only one element, it's already 
    // sorted.
    if (!head || !head->next) {
        return head;
    }
    // Split the linked list into halves using the fast and slow pointer 
    // technique.
    ListNode* secondHead = splitList(head);
    // Recursively sort both halves.
    ListNode* firstHalfSorted = sortLinkedList(head);
    ListNode* secondHalfSorted = sortLinkedList(secondHead);
    // Merge the sorted sublists.
    return merge(firstHalfSorted, secondHalfSorted);
}

ListNode* splitList(ListNode* head) {
    ListNode* slow = head;
    ListNode* fast = head;
    while (fast->next && fast->next->next) {
        slow = slow->next;
        fast = fast->next->next;
    }
    ListNode* secondHead = slow->next;
    slow->next = nullptr;
    return secondHead;
}

ListNode* merge(ListNode* l1, ListNode* l2) {
    ListNode dummy(0);
    // This pointer will be used to append nodes to the tail of the 
    // merged linked list.
    ListNode* tail = &dummy;
    // Continually append the node with the smaller value from each 
    // linked list to the merged linked list until one of the linked 
    // lists has no more nodes to merge.
    while (l1 && l2) {
        if (l1->val < l2->val) {
            tail->next = l1;
            l1 = l1->next;
        } else {
            tail->next = l2;
            l2 = l2->next;
        }
        tail = tail->next;
    }
    // One of the two linked lists could still have nodes remaining.
    // Attach those nodes to the end of the merged linked list.
    tail->next = l1 ? l1 : l2;
    return dummy.next;
}
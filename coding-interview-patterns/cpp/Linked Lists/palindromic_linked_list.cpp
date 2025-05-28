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

bool palindromicLinkedList(ListNode* head) {
    // Find the middle of the linked list and then reverse the second half of the
    // linked list starting at this midpoint.
    ListNode* mid = findMiddle(head);
    ListNode* secondHead = reverseList(mid);
    // Compare the first half and the reversed second half of the list
    ListNode* ptr1 = head;
    ListNode* ptr2 = secondHead;
    bool res = true;
    while (ptr2) {
        if (ptr1->val != ptr2->val) {
            res = false;
        }
        ptr1 = ptr1->next;
        ptr2 = ptr2->next;
    }
    return res;
}

// From the 'Reverse Linked List' problem.
ListNode* reverseList(ListNode* head) {
    ListNode* prevNode = nullptr;
    ListNode* currNode = head;
    while (currNode) {
        ListNode* nextNode = currNode->next;
        currNode->next = prevNode;
        prevNode = currNode;
        currNode = nextNode;
    }
    return prevNode;
}

// From the 'Linked List Midpoint' problem.
ListNode* findMiddle(ListNode* head) {
    ListNode* slow = head;
    ListNode* fast = head;
    while (fast != nullptr && fast->next != nullptr) {
        slow = slow->next;
        fast = fast->next->next;
    }
    return slow;
}
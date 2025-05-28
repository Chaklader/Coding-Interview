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

ListNode* linkedListReversal(ListNode* head) {
    ListNode* currNode = head;      
    ListNode* prevNode = nullptr;   
    // Reverse the direction of each node's pointer until 'currNode' 
    // is null.
    while (currNode != nullptr) {
        ListNode* nextNode = currNode->next;  
        currNode->next = prevNode;            
        prevNode = currNode;                 
        currNode = nextNode;                  
    }
    // 'prevNode' will be pointing at the head of the reversed linked 
    // list.
    return prevNode;
}
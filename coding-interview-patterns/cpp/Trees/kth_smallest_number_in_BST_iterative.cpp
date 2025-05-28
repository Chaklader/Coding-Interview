#include <stack>
#include "ds/TreeNode.h"
using ds::TreeNode;

/**
 * Definition of TreeNode:
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

int kthSmallestNumberInBSTIterative(TreeNode* root, int k) {
    std::stack<TreeNode*> stack;
    TreeNode* node = root;
    while (!stack.empty() || node) {
        // Move to the leftmost node and add nodes to the stack as we go so they
        // can be processed in future iterations.
        while (node) {
            stack.push(node);
            node = node->left;
        }
        // Pop the top node from the stack to process it, and decrement 'k'.
        node = stack.top();
        stack.pop();
        k--;
        // If we have processed 'k' nodes, return the value of the 'k'th smallest
        // node.
        if (k == 0) {
            return node->val;
        }
        // Move to the right subtree.
        node = node->right;
    }
    // If 'k' is larger than the number of nodes in the tree, 
    // return -1 or handle as needed.
    return -1;
}
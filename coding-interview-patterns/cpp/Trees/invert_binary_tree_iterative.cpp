#include <stack>
#include <algorithm>
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

TreeNode* invertBinaryTreeIterative(TreeNode* root) {
    if (!root)
        return nullptr;
    std::stack<TreeNode*> stack;
    stack.push(root);
    while (!stack.empty()) {
        TreeNode* node = stack.top();
        stack.pop();
        // Swap the left and right subtrees of the current node.
        std::swap(node->left, node->right);
        // Push the left and right subtrees onto the stack.
        if (node->left)
            stack.push(node->left);
        if (node->right)
            stack.push(node->right);
    }
    return root;
}
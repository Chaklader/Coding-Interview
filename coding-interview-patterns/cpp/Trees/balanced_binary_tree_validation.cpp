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

bool balancedBinaryTreeValidation(TreeNode* root) {
    return getHeightImbalance(root) != -1;
}

int getHeightImbalance(TreeNode* node) {
    // Base case: if the node is null, its height is 0.
    if (!node)
        return 0;
    // Recursively get the height of the left and right subtrees. If
    // either subtree is imbalanced, propagate -1 up the tree.
    int leftHeight = getHeightImbalance(node->left);
    int rightHeight = getHeightImbalance(node->right);
    if (leftHeight == -1 || rightHeight == -1)
        return -1;
    // If the current node's subtree is imbalanced
    // (height difference > 1), return -1.
    if (abs(leftHeight - rightHeight) > 1)
        return -1;
    // Return the height of the current subtree.
    return 1 + std::max(leftHeight, rightHeight);
}
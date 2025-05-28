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

TreeNode* invertBinaryTreeRecursive(TreeNode* root) {
    // Base case: If the node is null, there's nothing to invert.
    if (!root)
        return nullptr;
    // Swap the left and right subtrees of the current node.
    std::swap(root->left, root->right);
    // Recursively invert the left and right subtrees.
    invertBinaryTreeRecursive(root->left);
    invertBinaryTreeRecursive(root->right);
    return root;
}
#include <limits>
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

bool binarySearchTreeValidation(TreeNode* root) {
    // Start validation at the root node. The root node can contain any 
    // value, so set the initial lower and upper bounds to -infinity and 
    // +infinity, respectively.
    return isWithinBounds(root, std::numeric_limits<int>::min(), std::numeric_limits<int>::max());
}

bool isWithinBounds(TreeNode* node, int lowerBound, int upperBound) {
    // Base case: if the node is null, it satisfies the BST condition.
    if (!node)
        return true;
    // If the current node's value is not within the valid bounds, this 
    // tree is not a valid BST.
    if (!(lowerBound < node->val && node->val < upperBound))
        return false;
    // If the left subtree isn't a BST, this tree isn't a BST.
    if (!isWithinBounds(node->left, lowerBound, node->val))
        return false;
    // Otherwise, return true if the right subtree is also a BST.
    return isWithinBounds(node->right, node->val, upperBound);
}
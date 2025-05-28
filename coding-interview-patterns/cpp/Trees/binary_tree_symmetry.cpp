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

bool binaryTreeSymmetry(TreeNode* root) {
    if (!root)
        return true;  
    return compareTrees(root->left, root->right);
}

bool compareTrees(TreeNode* node1, TreeNode* node2) {
    // Base case: if both nodes are null, they're symmetric.
    if (!node1 && !node2)
        return true;
    // If one node is null and the other isn't, they aren't symmetric.
    if (!node1 || !node2)
        return false;
    // If the values of the current nodes don't match, trees aren't symmetric.
    if (node1->val != node2->val)
        return false;
    // Compare the 'node1's left subtree with 'node2's right subtree. If these 
    // aren't symmetric, the whole tree is not symmetric.
    if (!compareTrees(node1->left, node2->right))
        return false;
    // Compare the 'node1's right subtree with 'node2's left subtree. 
    return compareTrees(node1->right, node2->left);
}
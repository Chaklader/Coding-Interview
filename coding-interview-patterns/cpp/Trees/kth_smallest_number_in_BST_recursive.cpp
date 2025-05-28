#include <vector>
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

int kthSmallestNumberInBSTRecursive(TreeNode* root, int k) {
    std::vector<int> sortedList = inorder(root);
    return sortedList[k - 1];
}

// Inorder traversal function to attain a sorted list of nodes from the BST.
std::vector<int> inorder(TreeNode* node) {
    if (!node)
        return {};
    std::vector<int> left = inorder(node->left);
    left.push_back(node->val);
    std::vector<int> right = inorder(node->right);
    left.insert(left.end(), right.begin(), right.end());
    return left;
}
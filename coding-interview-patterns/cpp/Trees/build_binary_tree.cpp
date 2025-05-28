#include <vector>
#include <unordered_map>
#include "ds/TreeNode.h"
using ds::TreeNode;

/**
 * Definition of TreeNode:
 * struct TreeNode {
 *     int val;
 *     TreeNode* left;
 *     TreeNode* right;
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode* left, TreeNode* right) : val(x), left(left), right(right) {}
 * };
 */

TreeNode* buildBinaryTree(std::vector<int>& preorder, std::vector<int>& inorder) {
    // Populate the hash map with the inorder values and their indexes.
    std::unordered_map<int, int> inorderIndexesMap;
    for (int i = 0; i < inorder.size(); i++) {
        inorderIndexesMap[inorder[i]] = i;
    }
    // Build the tree and return its root node.
    int preorderIndex = 0;
    return buildSubtree(0, inorder.size() - 1, preorder, inorder, preorderIndex, inorderIndexesMap);
}

TreeNode* buildSubtree(int left, int right, std::vector<int>& preorder, std::vector<int>& inorder,
                       int& preorderIndex, std::unordered_map<int, int>& inorderIndexesMap) {
    // Base case: if no elements are in this range, return nullptr.
    if (left > right) {
        return nullptr;
    }
    int val = preorder[preorderIndex];
    // Set 'inorder_index' to the index of the same value pointed at by
    // 'preorder_index'. 
    int inorderIndex = inorderIndexesMap[val];
    TreeNode* node = new TreeNode(val);
    // Advance 'preorder_index' so it points to the value of the next
    // node to be created.
    preorderIndex++;
    // Build the left and right subtrees and connect them to the current
    // node.
    node->left = buildSubtree(left, inorderIndex - 1, preorder, inorder, preorderIndex, inorderIndexesMap);
    node->right = buildSubtree(inorderIndex + 1, right, preorder, inorder, preorderIndex, inorderIndexesMap);
    return node;
}
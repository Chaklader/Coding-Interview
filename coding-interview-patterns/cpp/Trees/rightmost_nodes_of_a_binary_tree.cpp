#include <vector>
#include <queue>
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

std::vector<int> rightmostNodesOfABinaryTree(TreeNode* root) {
    if (!root)
        return {};
    std::vector<int> res;
    std::queue<TreeNode*> queue;
    queue.push(root);
    while (!queue.empty()) {
        int levelSize = queue.size();
        // Add all the non-null child nodes of the current level to the 
        // queue.
        for (int i = 0; i < levelSize; i++) {
            TreeNode* node = queue.front();
            queue.pop();
            if (node->left)
                queue.push(node->left);
            if (node->right)
                queue.push(node->right);
            // Record this level's last node to the result array.
            if (i == levelSize - 1)
                res.push_back(node->val);
        }
    }
    return res;
}
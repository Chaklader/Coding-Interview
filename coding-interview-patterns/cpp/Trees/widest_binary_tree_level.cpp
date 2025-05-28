#include <deque>
#include <utility>
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

int widestBinaryTreeLevel(TreeNode* root) {
    if (!root) {
        return 0;
    }
    int maxWidth = 0;
    std::deque<std::pair<TreeNode*, int>> queue;
    queue.push_back(std::make_pair(root, 0));   // Stores (node, index) pairs.
    while (!queue.empty()) {
        int levelSize = queue.size();
        // Set the 'leftmostIndex' to the index of the first node in 
        // this level. Start 'rightmostIndex' at the same point as 
        // 'leftmostIndex' and update it as we traverse the level, 
        // eventually positioning it at the last node.
        int leftmostIndex = queue.front().second;
        int rightmostIndex = leftmostIndex;
        // Process all nodes at the current level. 
        for (int unused = 0; unused < levelSize; unused++) {
            TreeNode* node = queue.front().first;
            int i = queue.front().second;
            queue.pop_front();
            if (node->left) {
                queue.push_back(std::make_pair(node->left, 2 * i + 1));
            }
            if (node->right) {
                queue.push_back(std::make_pair(node->right, 2 * i + 2));
            }
            rightmostIndex = i;
        }
        maxWidth = std::max(maxWidth, rightmostIndex - leftmostIndex + 1);
    }
    return maxWidth;
}
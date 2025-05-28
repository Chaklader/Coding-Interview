#include <vector>
#include <unordered_map>
#include <queue>
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

std::vector<std::vector<int>> binaryTreeColumns(TreeNode* root) {
    if (!root)
        return {};
    std::unordered_map<int, std::vector<int>> columnMap;
    int leftmostColumn = 0, rightmostColumn = 0;
    std::queue<std::pair<TreeNode*, int>> queue;
    queue.push({root, 0});
    while (!queue.empty()) {
        TreeNode* node = queue.front().first;
        int column = queue.front().second;
        queue.pop();
        if (node) {
            // Add the current node's value to its corresponding list in the hash
            // map.
            columnMap[column].push_back(node->val);
            leftmostColumn = std::min(leftmostColumn, column);
            rightmostColumn = std::max(rightmostColumn, column);
            // Add the current node's children to the queue with their respective
            // column ids.
            queue.push({node->left, column - 1});
            queue.push({node->right, column + 1});
        }
    }
    // Construct the output list by collecting values from each column in the hash   
    // map in the correct order. 
    std::vector<std::vector<int>> res;
    for (int i = leftmostColumn; i <= rightmostColumn; i++) {
        if (columnMap.count(i)) {
            res.push_back(columnMap[i]);
        }
    }
    return res;
}
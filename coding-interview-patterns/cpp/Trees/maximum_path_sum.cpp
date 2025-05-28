#include <algorithm>
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

int maxPathSum(TreeNode* root) {
    int maxSum = std::numeric_limits<int>::min();
    maxPathSumHelper(root, maxSum);
    return maxSum;
}

int maxPathSumHelper(TreeNode* node, int& maxSum) {
    // Base case: null nodes have no path sum.
    if (!node)
        return 0;
    // Collect the maximum gain we can attain from the left and right
    // subtrees, setting them to 0 if they're negative.
    int leftSum = std::max(maxPathSumHelper(node->left, maxSum), 0);
    int rightSum = std::max(maxPathSumHelper(node->right, maxSum), 0);
    // Update the overall maximum path sum if the current path sum is 
    // larger.
    maxSum = std::max(maxSum, node->val + leftSum + rightSum);
    // Return the maximum sum of a single, continuous path with the 
    // current node as an endpoint.
    return node->val + std::max(leftSum, rightSum);
}
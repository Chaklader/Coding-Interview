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

TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
    TreeNode* lca = nullptr;
    dfs(root, p, q, lca);
    return lca;
}

bool dfs(TreeNode* node, TreeNode* p, TreeNode* q, TreeNode*& lca) {
    // Base case: a null node is neither 'p' nor 'q'.
    if (!node)
        return false;
    bool nodeIsPOrQ = (node == p || node == q);
    // Recursively determine if the left and right subtrees contain 'p' 
    // or 'q'.
    bool leftContainsPOrQ = dfs(node->left, p, q, lca);
    bool rightContainsPOrQ = dfs(node->right, p, q, lca);
    // If two of the above three variables are true, the current node is 
    // the LCA.
    if (nodeIsPOrQ + leftContainsPOrQ + rightContainsPOrQ == 2)
        lca = node;
    // Return true if the current subtree contains 'p' or 'q'.
    return nodeIsPOrQ || leftContainsPOrQ || rightContainsPOrQ;
}
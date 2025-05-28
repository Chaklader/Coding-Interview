#include <string>
#include <sstream>
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

std::string serialize(TreeNode* root) {
    // Perform a preorder traversal of the tree and build the 
    // serialized string directly during the traversal. 
    std::string serializedStr;
    preorderSerialize(root, serializedStr);
    return serializedStr;
}

// Helper function to perform serialization through preorder traversal.
void preorderSerialize(TreeNode* node, std::string& serializedStr) {
    // Base case: mark null nodes as '#'.
    if (!node) {
        serializedStr += "# ";
        return;
    }
    // Preorder traversal processes the current node first, then the left and right
    // children.
    serializedStr += std::to_string(node->val) + " ";
    preorderSerialize(node->left, serializedStr);
    preorderSerialize(node->right, serializedStr);
}

TreeNode* deserialize(std::string data) {
    // Use an input string stream to parse the serialized tree data.
    std::istringstream nodeValues(data);
    return buildTree(nodeValues);
}

// Helper function to construct the tree using preorder traversal.
TreeNode* buildTree(std::istringstream& values) {
    std::string val;
    values >> val;
    // Base case: '#' indicates a null node.
    if (val == "#")
        return nullptr;
    // Use preorder traversal processes the current node first, then the left and 
    // right children. 
    TreeNode* node = new TreeNode(std::stoi(val));
    node->left = buildTree(values);
    node->right = buildTree(values);
    return node;
}
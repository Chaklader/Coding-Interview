#include <unordered_map>
#include <vector>
#include "ds/GraphNode.h"
using ds::GraphNode;

/**
 * Definition of GraphNode:
 * class GraphNode {
 * public:
 *     int val;
 *     std::vector<GraphNode*> neighbors;
 *     GraphNode(int _val) {
 *         val = _val;
 *         neighbors = vector<GraphNode*>();
 *     }
 * };
 */

GraphNode* graphDeepCopy(GraphNode* node) {
    if (!node) {
        return nullptr;
    }
    std::unordered_map<GraphNode*, GraphNode*> cloneMap;
    return dfs(node, cloneMap);
}

GraphNode* dfs(GraphNode* node, std::unordered_map<GraphNode*, GraphNode*>& cloneMap) {
    // If this node was already cloned, then return this previously
    // cloned node.
    if (cloneMap.find(node) != cloneMap.end()) {
        return cloneMap[node];
    }
    // Clone the current node.
    GraphNode* clonedNode = new GraphNode(node->val);
    // Store the current clone to ensure it doesn't need to be created
    // again in future DFS calls.
    cloneMap[node] = clonedNode;
    // Iterate through the neighbors of the current node to connect
    // their clones to the current cloned node.
    for (GraphNode* neighbor : node->neighbors) {
        GraphNode* clonedNeighbor = dfs(neighbor, cloneMap);
        clonedNode->neighbors.push_back(clonedNeighbor);
    }
    return clonedNode;
}
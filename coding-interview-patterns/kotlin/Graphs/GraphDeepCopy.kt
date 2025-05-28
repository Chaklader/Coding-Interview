import ds.GraphNode

/*
    Definition of GraphNode:
    data class GraphNode(
        val value: Int,
        val neighbors: MutableList<GraphNode> = mutableListOf()
    )
*/

fun graphDeepCopy(node: GraphNode?): GraphNode? {
    if (node == null) {
        return null
    }
    return dfs(node, mutableMapOf())
}

fun dfs(node: GraphNode, cloneMap: MutableMap<GraphNode, GraphNode>): GraphNode {
    // If this node was already cloned, then return this previously
    // cloned node.
    if (node in cloneMap) {
        return cloneMap[node]!!
    }
    // Clone the current node.
    val clonedNode = GraphNode(node.value)
    // Store the current clone to ensure it doesn't need to be created
    // again in future DFS calls.
    cloneMap[node] = clonedNode
    // Iterate through the neighbors of the current node to connect
    // their clones to the current cloned node.
    for (neighbor in node.neighbors) {
        val clonedNeighbor = dfs(neighbor, cloneMap)
        clonedNode.neighbors.add(clonedNeighbor)
    }
    return clonedNode
}

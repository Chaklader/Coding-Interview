fun bipartiteGraphValidation(graph: List<List<Int>>): Boolean {
    val colors = IntArray(graph.size)
    // Determine if each graph component is bipartite.
    for (i in graph.indices) {
        if (colors[i] == 0 && !dfs(i, 1, graph, colors)) {
            return false
        }
    }
    return true
}

fun dfs(node: Int, color: Int, graph: List<List<Int>>, colors: IntArray): Boolean {
    colors[node] = color
    for (neighbor in graph[node]) {
        // If the current neighbor has the same color as the current
        // node, the graph is not bipartite.
        if (colors[neighbor] == color) {
            return false
        }
        // If the current neighbor is not colored, color it with the
        // other color and continue the DFS.
        if (colors[neighbor] == 0 && !dfs(neighbor, -color, graph, colors)) {
            return false
        }
    }
    return true
}

#include <vector>

bool bipartiteGraphValidation(std::vector<std::vector<int>>& graph) {
    std::vector<int> colors(graph.size(), 0);
    // Determine if each graph component is bipartite.
    for (int i = 0; i < graph.size(); i++) {
        if (colors[i] == 0 && !dfs(i, 1, graph, colors)) {
            return false;
        }
    }
    return true;
}

bool dfs(int node, int color, std::vector<std::vector<int>>& graph, std::vector<int>& colors) {
    colors[node] = color;
    for (int neighbor : graph[node]) {
        // If the current neighbor has the same color as the current 
        // node, the graph is not bipartite.
        if (colors[neighbor] == color) {
            return false;
        }
        // If the current neighbor is not colored, color it with the 
        // other color and continue the DFS.
        if (colors[neighbor] == 0 && !dfs(neighbor, -color, graph, colors)) {
            return false;
        }
    }
    return true;
}
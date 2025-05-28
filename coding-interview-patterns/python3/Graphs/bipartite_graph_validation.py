from typing import List


def bipartite_graph_validation(graph: List[List[int]]) -> bool:
    colors = [0] * len(graph)
    # Determine if each graph component is bipartite.
    for i in range(len(graph)):
        if colors[i] == 0 and not dfs(i, 1, graph, colors):
            return False
    return True

def dfs(node: int, color: int, graph: List[List[int]], colors: List[int]) -> bool:
    colors[node] = color
    for neighbor in graph[node]:
        # If the current neighbor has the same color as the current 
        # node, the graph is not bipartite.
        if colors[neighbor] == color:
            return False
        # If the current neighbor is not colored, color it with the 
        # other color and continue the DFS.
        if colors[neighbor] == 0 and not dfs(neighbor, -color, graph, colors):
            return False
    return True

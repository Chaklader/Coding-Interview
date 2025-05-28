from ds import GraphNode

"""
Definition of GraphNode:
class GraphNode:
    def __init__(self, val):
        self.val = val
        self.neighbors = []
"""


def graph_deep_copy(node: GraphNode) -> GraphNode:
    if not node:
        return None
    return dfs(node)

def dfs(node: GraphNode, clone_map = {}) -> GraphNode:
    # If this node was already cloned, then return this previously  
    # cloned node.
    if node in clone_map:
        return clone_map[node]
    # Clone the current node.
    cloned_node = GraphNode(node.val)
    # Store the current clone to ensure it doesn't need to be created 
    # again in future DFS calls.
    clone_map[node] = cloned_node
    # Iterate through the neighbors of the current node to connect  
    # their clones to the current cloned node.
    for neighbor in node.neighbors:
        cloned_neighbor = dfs(neighbor, clone_map)
        cloned_node.neighbors.append(cloned_neighbor)
    return cloned_node

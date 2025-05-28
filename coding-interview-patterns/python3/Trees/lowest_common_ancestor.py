from ds import TreeNode

"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
"""


def lowest_common_ancestor(root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
    dfs(root, p, q)
    return lca

def dfs(node: TreeNode, p: TreeNode, q: TreeNode) -> bool:
    global lca
    # Base case: a null node is neither 'p' nor 'q'.
    if not node:
        return False
    node_is_p_or_q = node == p or node == q
    # Recursively determine if the left and right subtrees contain 'p' 
    # or 'q'.
    left_contains_p_or_q = dfs(node.left, p, q)
    right_contains_p_or_q = dfs(node.right, p, q)
    # If two of the above three variables are true, the current node is 
    # the LCA.
    if (node_is_p_or_q + left_contains_p_or_q + right_contains_p_or_q == 2):
        lca = node
    # Return true if the current subtree contains 'p' or 'q'.
    return (node_is_p_or_q or left_contains_p_or_q or right_contains_p_or_q)

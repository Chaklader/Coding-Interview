from ds import TreeNode

"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
"""


def binary_search_tree_validation(root: TreeNode) -> bool:
    # Start validation at the root node. The root node can contain any 
    # value, so set the initial lower and upper bounds to -infinity and 
    # +infinity, respectively.
    return is_within_bounds(root, float('-inf'), float('inf'))

def is_within_bounds(node: TreeNode,
                     lower_bound: int, upper_bound: int) -> bool:
    # Base case: if the node is null, it satisfies the BST condition.
    if not node:
        return True
    # If the current node's value is not within the valid bounds, this 
    # tree is not a valid BST.
    if not lower_bound < node.val < upper_bound:
        return False
    # If the left subtree isn't a BST, this tree isn't a BST.
    if not is_within_bounds(node.left, lower_bound, node.val):
        return False
    # Otherwise, return true if the right subtree is also a BST.
    return is_within_bounds(node.right, node.val, upper_bound)

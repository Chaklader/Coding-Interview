from ds import TreeNode

"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
"""


def balanced_binary_tree_validation(root: TreeNode) -> bool:
    return get_height_imbalance(root) != -1

def get_height_imbalance(node: TreeNode) -> int:
    # Base case: if the node is null, its height is 0.
    if not node:
        return 0
    # Recursively get the height of the left and right subtrees. If
    # either subtree is imbalanced, propagate -1 up the tree.
    left_height = get_height_imbalance(node.left)
    right_height = get_height_imbalance(node.right)
    if left_height == -1 or right_height == -1:
        return -1
    # If the current node's subtree is imbalanced
    # (height difference > 1), return -1.
    if abs(left_height - right_height) > 1:
        return -1
    # Return the height of the current subtree.
    return 1 + max(left_height, right_height)

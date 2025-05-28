from ds import TreeNode

"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
"""


def binary_tree_symmetry(root: TreeNode) -> bool:
    if not root:
        return True  
    return compare_trees(root.left, root.right)


def compare_trees(node1: TreeNode, node2: TreeNode) -> bool:
    # Base case: if both nodes are null, they're symmetric.
    if not node1 and not node2:
        return True
    # If one node is null and the other isn't, they aren't symmetric.
    if not node1 or not node2:
        return False
    # If the values of the current nodes don't match, trees aren't symmetric.
    if node1.val != node2.val:
        return False
    # Compare the 'node1's left subtree with 'node2's right subtree. If these 
    # aren't symmetric, the whole tree is not symmetric.
    if not compare_trees(node1.left, node2.right):
        return False
    # Compare the 'node1's right subtree with 'node2's left subtree. 
    return compare_trees(node1.right, node2.left)
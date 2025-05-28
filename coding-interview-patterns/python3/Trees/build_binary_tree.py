from ds import TreeNode
from typing import List

"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
"""


preorder_index = 0
inorder_indexes_map = {}

def build_binary_tree(preorder: List[int], inorder: List[int]) -> TreeNode:
    global inorder_indexes_map
    # Populate the hash map with the inorder values and their indexes.
    for i, val in enumerate(inorder):
        inorder_indexes_map[val] = i
    # Build the tree and return its root node.
    return build_subtree(0, len(inorder) - 1, preorder, inorder)

def build_subtree(left: int, right: int, preorder: List[int], inorder: List[int]) -> TreeNode:
    global preorder_index, inorder_indexes_map
    # Base case: if no elements are in this range, return None.
    if left > right:
        return None
    val = preorder[preorder_index]
    # Set 'inorder_index' to the index of the same value pointed at by
    # 'preorder_index'.
    inorder_index = inorder_indexes_map[val]
    node = TreeNode(val)
    # Advance 'preorder_index' so it points to the value of the next
    # node to be created.
    preorder_index += 1
    # Build the left and right subtrees and connect them to the current
    # node.
    node.left = build_subtree(
        left, inorder_index - 1, preorder, inorder
    )
    node.right = build_subtree(
        inorder_index + 1, right, preorder, inorder
    )
    return node

from ds import TreeNode

"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
"""


max_sum = float('-inf')

def max_path_sum(root: TreeNode) -> int:
    global max_sum
    max_path_sum_helper(root)
    return max_sum

def max_path_sum_helper(node: TreeNode) -> int:
    global max_sum
    # Base case: null nodes have no path sum.
    if not node:
        return 0
    # Collect the maximum gain we can attain from the left and right 
    # subtrees, setting them to 0 if they're negative.
    left_sum = max(max_path_sum_helper(node.left), 0)
    right_sum = max(max_path_sum_helper(node.right), 0)
    # Update the overall maximum path sum if the current path sum is 
    # larger.
    max_sum = max(max_sum, node.val + left_sum + right_sum)
    # Return the maximum sum of a single, continuous path with the 
    # current node as an endpoint.
    return node.val + max(left_sum, right_sum)

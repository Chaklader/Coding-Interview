import ds.TreeNode

/*
    Definition of TreeNode:

    data class TreeNode(
        var value: Int, 
        var left: TreeNode? = null, 
        var right: TreeNode? = null
    )
*/

fun balancedBinaryTreeValidation(root: TreeNode?): Boolean {
    return getHeightImbalance(root) != -1
}

fun getHeightImbalance(node: TreeNode?): Int {
    // Base case: if the node is null, its height is 0.
    if (node == null) {
        return 0
    }
    // Recursively get the height of the left and right subtrees. If
    // either subtree is imbalanced, propagate -1 up the tree.
    val leftHeight = getHeightImbalance(node.left)
    val rightHeight = getHeightImbalance(node.right)
    if (leftHeight == -1 || rightHeight == -1) {
        return -1
    }
    // If the current node's subtree is imbalanced
    // (height difference > 1), return -1.
    if (Math.abs(leftHeight - rightHeight) > 1) {
        return -1
    }
    // Return the height of the current subtree.
    return 1 + Math.max(leftHeight, rightHeight)
}

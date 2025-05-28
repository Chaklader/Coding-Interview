import ds.TreeNode

/*
    Definition of TreeNode:

    data class TreeNode(
        var value: Int,
        var left: TreeNode? = null,
        var right: TreeNode? = null
    )
*/

fun binarySearchTreeValidation(root: TreeNode?): Boolean {
    // Start validation at the root node. The root node can contain any
    // value, so set the initial lower and upper bounds to -infinity and
    // +infinity, respectively.
    return isWithinBounds(root, Int.MIN_VALUE, Int.MAX_VALUE)
}

fun isWithinBounds(node: TreeNode?, lowerBound: Int, upperBound: Int): Boolean {
    // Base case: if the node is null, it satisfies the BST condition.
    if (node == null) {
        return true
    }
    // If the current node's value is not within the valid bounds, this
    // tree is not a valid BST.
    if (node.value <= lowerBound || node.value >= upperBound) {
        return false
    }
    // If the left subtree isn't a BST, this tree isn't a BST.
    if (!isWithinBounds(node.left, lowerBound, node.value)) {
        return false
    }
    // Otherwise, return true if the right subtree is also a BST.
    return isWithinBounds(node.right, node.value, upperBound)
}

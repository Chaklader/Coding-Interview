import ds.TreeNode

/*
    Definition of TreeNode:

    data class TreeNode(
        var value: Int,
        var left: TreeNode? = null,
        var right: TreeNode? = null
    )
*/

fun binaryTreeSymmetry(root: TreeNode?): Boolean {
    if (root == null) {
        return true
    }
    return compareTrees(root.left, root.right)
}

fun compareTrees(node1: TreeNode?, node2: TreeNode?): Boolean {
    // Base case: if both nodes are null, they're symmetric.
    if (node1 == null && node2 == null) {
        return true
    }
    // If one node is null and the other isn't, they aren't symmetric.
    if (node1 == null || node2 == null) {
        return false
    }
    // If the values of the current nodes don't match, trees aren't symmetric.
    if (node1.value != node2.value) {
        return false
    }
    // Compare the 'node1's left subtree with 'node2's right subtree. If these
    // aren't symmetric, the whole tree is not symmetric.
    if (!compareTrees(node1.left, node2.right)) {
        return false
    }
    // Compare the 'node1's right subtree with 'node2's left subtree.
    return compareTrees(node1.right, node2.left)
}

import ds.TreeNode

/*
    Definition of TreeNode:

    data class TreeNode(
        var value: Int, 
        var left: TreeNode? = null, 
        var right: TreeNode? = null
    )
*/

fun invertBinaryTreeRecursive(root: TreeNode?): TreeNode? {
    // Base case: If the node is null, there's nothing to invert.
    if (root == null) {
        return null
    }
    // Swap the left and right subtrees of the current node.
    val temp = root.left
    root.left = root.right
    root.right = temp
    // Recursively invert the left and right subtrees.
    invertBinaryTreeRecursive(root.left)
    invertBinaryTreeRecursive(root.right)
    return root
}

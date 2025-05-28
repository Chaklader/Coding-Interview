import ds.TreeNode

/*
    Definition of TreeNode:

    data class TreeNode(
        var value: Int,
        var left: TreeNode? = null,
        var right: TreeNode? = null
    )
*/

fun kthSmallestNumberInBSTRecursive(root: TreeNode?, k: Int): Int {
    val sortedList = inorder(root)
    return sortedList[k - 1]
}

// Inorder traversal function to attain a sorted list of nodes from the BST.
fun inorder(node: TreeNode?): List<Int> {
    if (node == null) {
        return emptyList()
    }
    return inorder(node.left) + listOf(node.value) + inorder(node.right)
}

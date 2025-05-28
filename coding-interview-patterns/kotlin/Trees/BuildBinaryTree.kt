import ds.TreeNode

/*
    Definition of TreeNode:

    data class TreeNode(
        var value: Int,
        var left: TreeNode? = null,
        var right: TreeNode? = null
    )
*/

fun buildBinaryTree(preorder: List<Int>, inorder: List<Int>): TreeNode? {
    val inorderIndexesMap = hashMapOf<Int, Int>()
    val preorderIndex = intArrayOf(0)
    // Populate the hash map with the inorder values and their indexes.
    for (i in inorder.indices) {
        inorderIndexesMap[inorder[i]] = i
    }
    // Build the tree and return its root node.
    return buildSubtree(0, inorder.size - 1, preorder, inorder, preorderIndex, inorderIndexesMap)
}

fun buildSubtree(
        left: Int,
        right: Int,
        preorder: List<Int>,
        inorder: List<Int>,
        preorderIndex: IntArray,
        inorderIndexesMap: Map<Int, Int>
): TreeNode? {
    // Base case: if no elements are in this range, return null.
    if (left > right) {
        return null
    }
    val value = preorder[preorderIndex[0]]
    // Set 'inorderIndex' to the index of the same value pointed at by
    // 'preorderIndex'.
    val inorderIndex = inorderIndexesMap[value]!!
    val node = TreeNode(value)
    // Advance 'preorderIndex' so it points to the value of the next
    // node to be created.
    preorderIndex[0]++
    // Build the left and right subtrees and connect them to the current
    // node.
    node.left =
            buildSubtree(
                    left,
                    inorderIndex - 1,
                    preorder,
                    inorder,
                    preorderIndex + 1,
                    inorderIndexesMap
            )
    node.right =
            buildSubtree(
                    inorderIndex + 1,
                    right,
                    preorder,
                    inorder,
                    preorderIndex + inorderIndex - left + 1,
                    inorderIndexesMap
            )
    return node
}

import ds.TreeNode

/*
    Definition of TreeNode:

    data class TreeNode(
        var value: Int,
        var left: TreeNode? = null,
        var right: TreeNode? = null
    )
*/

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    var lca: MutableList<TreeNode?> = mutableListOf(null)
    dfs(root, p, q, lca)
    return lca[0]
}

fun dfs(node: TreeNode?, p: TreeNode?, q: TreeNode?, lca: MutableList<TreeNode?>): Boolean {
    // Base case: a null node is neither 'p' nor 'q'.
    if (node == null) {
        return false
    }
    val nodeIsPOrQ = node == p || node == q
    // Recursively determine if the left and right subtrees contain 'p'
    // or 'q'.
    val leftContainsPOrQ = dfs(node.left, p, q, lca)
    val rightContainsPOrQ = dfs(node.right, p, q, lca)
    // If two of the above three variables are true, the current node is
    // the LCA.
    if ((nodeIsPOrQ && leftContainsPOrQ) ||
                    (nodeIsPOrQ && rightContainsPOrQ) ||
                    (leftContainsPOrQ && rightContainsPOrQ)
    ) {
        lca[0] = node
    }

    // Return true if the current subtree contains 'p' or 'q'.
    return nodeIsPOrQ || leftContainsPOrQ || rightContainsPOrQ
}

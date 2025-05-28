import java.util.LinkedList
import ds.TreeNode

/*
    Definition of TreeNode:

    data class TreeNode(
        var value: Int,
        var left: TreeNode? = null,
        var right: TreeNode? = null
    )
*/

fun serialize(root: TreeNode?): String {
    // Perform a preorder traversal to add node values to a list, then convert the
    // list to a string.
    val serializedList = mutableListOf<String>()
    preorderSerialize(root, serializedList)
    // Convert the list to a string and separate each value using a comma
    // delimiter.
    return serializedList.joinToString(",")
}

// Helper function to perform serialization through preorder traversal.
fun preorderSerialize(node: TreeNode?, serializedList: MutableList<String>) {
    // Base case: mark null nodes as '#'.
    if (node == null) {
        serializedList.add("#")
        return
    }
    // Preorder traversal processes the current node first, then the left and right
    // children.
    serializedList.add(node.value.toString())
    preorderSerialize(node.left, serializedList)
    preorderSerialize(node.right, serializedList)
}

fun deserialize(data: String): TreeNode? {
    // Obtain the node values by splitting the string using the comma delimiter.
    val nodeValues = LinkedList<String>(data.split(","))
    return buildTree(nodeValues)
}

// Helper function to construct the tree using preorder traversal.
fun buildTree(values: LinkedList<String>): TreeNode? {
    val value = values.poll()
    // Base case: '#' indicates a null node.
    if (value == "#") {
        return null
    }
    // Use preorder traversal processes the current node first, then the left and
    // right children.
    val node = TreeNode(value.toInt())
    node.left = buildTree(values)
    node.right = buildTree(values)
    return node
}

data class TrieNode(
    var isWord: Boolean = false,
    val children: HashMap<Char, TrieNode> = hashMapOf()
)

class Trie {
    val root = TrieNode()

    fun insert(word: String) {
        var node = root
        for (c in word.toCharArray()) {
            // For each character in the word, if it's not a child of
            // the current node, create a new TrieNode for that
            // character.
            if (c !in node.children) {
                node.children[c] = TrieNode()
            }
            node = node.children[c]!!
        }
        // Mark the last node as the end of a word.
        node.isWord = true
    }

    fun search(word: String): Boolean {
        var node = root
        for (c in word.toCharArray()) {
            // For each character in the word, if it's not a child of
            // the current node, the word doesn't exist in the Trie.
            if (c !in node.children) {
                return false
            }
            node = node.children[c]!!
        }
        // Return whether the current node is marked as the end of the word.
        return node.isWord
    }

    fun hasPrefix(prefix: String): Boolean {
        var node = root
        for (c in prefix.toCharArray()) {
            if (c !in node.children) {
                return false
            }
            node = node.children[c]!!
        }
        // Once we've traversed the nodes corresponding to each
        // character in the prefix, return True.
        return true
    }
}

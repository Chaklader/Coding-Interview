data class TrieNode(
    var isWord: Boolean = false,
    val children: HashMap<Char, TrieNode> = hashMapOf()
)

class InsertAndSearchWordsWithWildcards {
    private val root = TrieNode()

    fun insert(word: String) {
        var node = root
        for (c in word) {
            if (c !in node.children) {
                node.children[c] = TrieNode()
            }
            node = node.children[c]!!
        }
        node.isWord = true
    }

    fun search(word: String): Boolean {
        // Start searching from the root of the trie.
        return searchHelper(0, word, root)
    }

    fun searchHelper(wordIndex: Int, word: String, node: TrieNode): Boolean {
        var node = node
        for (i in wordIndex until word.length) {
            val c = word[i]
            if (c == '.') {
                for (child in node.children.values) {
                    // If a match is found, return true.
                    if (searchHelper(i + 1, word, child)) {
                        return true
                    }
                }
            } else if (c in node.children) {
                node = node.children[c]!!
            } else {
                return false
            }
            // After processing the last character, return true if we've
            // reached the end of a word.
        }
        return node.isWord
    }
}

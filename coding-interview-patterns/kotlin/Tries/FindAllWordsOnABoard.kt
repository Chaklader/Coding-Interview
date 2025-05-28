data class TrieNode(
    var word: String? = null,
    val children: HashMap<Char, TrieNode> = hashMapOf()
)

fun findAllWordsOnABoard(board: Array<CharArray>, words: List<String>): List<String> {
    val root = TrieNode()
    // Insert every word into the trie.
    for (word in words) {
        var node = root
        for (c in word.toCharArray()) {
            if (c !in node.children) {
                node.children[c] = TrieNode()
            }
            node = node.children[c]!!
        }
        node.word = word
    }
    val res = mutableListOf<String>()
    // Start a DFS call from each cell of the board that contains a
    // child of the root node, which represents the first letter of a
    // word in the trie.
    for (r in 0 until board.size) {
        for (c in 0 until board[0].size) {
            if (board[r][c] in root.children) {
                dfs(board, r, c, root.children[board[r][c]], res)
            }
        }
    }
    return res
}

fun dfs(board: Array<CharArray>, r: Int, c: Int, node: TrieNode?, res: MutableList<String>) {
    // If the current node represents the end of a word, add the word to
    // the result.
    if (node?.word != null) {
        res.add(node.word!!)
        // Ensure the current word is only added once.
        node.word = null
    }
    val temp = board[r][c]
    // Mark the current cell as visited.
    board[r][c] = '#'
    // Explore all adjacent cells that correspond with a child of the
    // current TrieNode.
    val dirs = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
    for ((dr, dc) in dirs) {
        val nextR = r + dr
        val nextC = c + dc
        if (isWithinBounds(board, nextR, nextC) && board[nextR][nextC] in node?.children.orEmpty()) {
            dfs(board, nextR, nextC, node?.children?.get(board[nextR][nextC]), res)
        }
        // Backtrack by reverting the cell back to its original character.
        board[r][c] = temp
    }
}

fun isWithinBounds(board: Array<CharArray>, r: Int, c: Int): Boolean {
    return r in board.indices && c in board[0].indices
}

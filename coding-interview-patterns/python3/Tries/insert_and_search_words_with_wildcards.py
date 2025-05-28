class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_word = False

class InsertAndSearchWordsWithWildcards:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        node = self.root
        for c in word:
            if c not in node.children:
                node.children[c] = TrieNode()
            node = node.children[c]
        node.is_word = True

    def search(self, word: str) -> bool:
        # Start searching from the root of the trie.
        return self.search_helper(0, word, self.root)

    def search_helper(self, word_index: int, word: str, node: TrieNode) -> bool:
        for i in range(word_index, len(word)):
            c = word[i]
            # If a wildcard character is encountered, recursively
            # search for the rest of the word from each child node.
            if c == '.':
                for child in node.children.values():
                    # If a match is found, return true.
                    if self.search_helper(i + 1, word, child):
                        return True
                return False
            elif c in node.children:
                node = node.children[c]
            else:
                return False
            # After processing the last character, return true if we've
            # reached the end of a word.
        return node.is_word
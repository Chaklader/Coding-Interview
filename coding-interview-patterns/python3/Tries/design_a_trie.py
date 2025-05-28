class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_word = False


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        node = self.root
        for c in word:
            # For each character in the word, if it's not a child of
            # the current node, create a new TrieNode for that
            # character.
            if c not in node.children:
                node.children[c] = TrieNode()
            node = node.children[c]
            # Mark the last node as the end of a word.
        node.is_word = True

    def search(self, word: str) -> bool:
        node = self.root
        for c in word:
            # For each character in the word, if it's not a child of
            # the current node, the word doesn't exist in the Trie.
            if c not in node.children:
                return False
            node = node.children[c]
            # Return whether the current node is marked as the end of the
            # word.
        return node.is_word
        
    def has_prefix(self, prefix: str) -> bool:
        node = self.root
        for c in prefix:
            if c not in node.children:
                return False
            node = node.children[c]
        # Once we've traversed the nodes corresponding to each
        # character in the prefix, return True.
        return True
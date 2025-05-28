#include <unordered_map>
#include <string>

class TrieNode {
public:
    std::unordered_map<char, TrieNode*> children;
    bool isWord;
    TrieNode() : isWord(false) {}
    ~TrieNode() {
        for (auto& pair : children) {
            delete pair.second;
        }
    }
};

class Trie {
public:
    Trie() {
        root = new TrieNode();
    }

    ~Trie() {
        delete root;
    }

    void insert(std::string word) {
        TrieNode* node = root;
        for (char c : word) {
            // For each character in the word, if it's not a child of
            // the current node, create a new TrieNode for that 
            // character.
            if (node->children.find(c) == node->children.end()) {
                node->children[c] = new TrieNode();
            }
            node = node->children[c];
        }
        // Mark the last node as the end of a word.
        node->isWord = true;
    }

    bool search(std::string word) {
        TrieNode* node = root;
        for (char c : word) {
            // For each character in the word, if it's not a child of
            // the current node, the word doesn't exist in the Trie.
            if (node->children.find(c) == node->children.end()) {
                return false;
            }
            node = node->children[c];
        }
        // Return whether the current node is marked as the end of the
        // word.
        return node->isWord;
    }

    bool hasPrefix(std::string prefix) {
        TrieNode* node = root;
        for (char c : prefix) {
            if (node->children.find(c) == node->children.end()) {
                return false;
            }
            node = node->children[c];
        }
        // Once we've traversed the nodes corresponding to each
        // character in the prefix, return True.
        return true;
    }

private:
    TrieNode* root;
};
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

class InsertAndSearchWordsWithWildcards {
public:
    InsertAndSearchWordsWithWildcards() {
        root = new TrieNode();
    }

    ~InsertAndSearchWordsWithWildcards() {
        delete root;
    }

    void insert(std::string word) {
        TrieNode* node = root;
        for (char c : word) {
            if (node->children.find(c) == node->children.end()) {
                node->children[c] = new TrieNode();
            }
            node = node->children[c];
        }
        node->isWord = true;
    }

    bool search(std::string word) {
        // Start searching from the root of the trie.
        return searchHelper(0, word, root);
    }

private:
    TrieNode* root;
    
    bool searchHelper(int wordIndex, std::string word, TrieNode* node) {
        for (int i = wordIndex; i < word.length(); i++) {
            char c = word[i];
            // If a wildcard character is encountered, recursively
            // search for the rest of the word from each child node. 
            if (c == '.') {
                for (auto& pair : node->children) {
                    // If a match is found, return true.
                    if (searchHelper(i + 1, word, pair.second)) {
                        return true;
                    }
                }
                return false;
            } else if (node->children.find(c) != node->children.end()) {
                node = node->children[c];
            } else {
                return false;
            }
        }
        // After processing the last character, return true if we've
        // reached the end of a word. 
        return node->isWord;
    }
};
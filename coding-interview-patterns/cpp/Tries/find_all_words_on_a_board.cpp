#include <unordered_map>
#include <vector>
#include <string>

class TrieNode {
public:
    std::unordered_map<char, TrieNode*> children;
    std::string word;
    TrieNode() : word("") {}
    ~TrieNode() {
        for (auto& pair : children) {
            delete pair.second;
        }
    }
};

std::vector<std::string> findAllWordsOnABoard(std::vector<std::vector<char>>& board, std::vector<std::string>& words) {
    TrieNode* root = new TrieNode();
    // Insert every word into the trie.
    for (std::string& word : words) {
        TrieNode* node = root;
        for (char c : word) {
            if (node->children.find(c) == node->children.end()) {
                node->children[c] = new TrieNode();
            }
            node = node->children[c];
        }
        node->word = word;
    }
    std::vector<std::string> res;
    // Start a DFS call from each cell of the board that contains a
    // child of the root node, which represents the first letter of a
    // word in the trie.
    int rows = board.size();
    int cols = board[0].size();
    for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {
            if (root->children.find(board[r][c]) != root->children.end()) {
                dfs(board, r, c, root->children[board[r][c]], res);
            }
        }
    }
    delete root;
    return res;
}

void dfs(std::vector<std::vector<char>>& board, int r, int c, TrieNode* node, std::vector<std::string>& res) {
    // If the current node represents the end of a word, add the word to
    // the result.
    if (!node->word.empty()) {
        res.push_back(node->word);
        // Ensure the current word is only added once.
        node->word = "";
    }
    char temp = board[r][c];
    // Mark the current cell as visited.
    board[r][c] = '#';
    // Explore all adjacent cells that correspond with a child of the 
    // current TrieNode.
    std::vector<std::pair<int, int>> dirs = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    for (auto& dir : dirs) {
        int next_r = r + dir.first;
        int next_c = c + dir.second;
        if (isWithinBounds(next_r, next_c, board) &&
            node->children.find(board[next_r][next_c]) != node->children.end()) {
            dfs(board, next_r, next_c, node->children[board[next_r][next_c]], res);
        }
    }
    // Backtrack by reverting the cell back to its original character.
    board[r][c] = temp;
}

bool isWithinBounds(int r, int c, std::vector<std::vector<char>>& board) {
    return r >= 0 && r < board.size() && c >= 0 && c < board[0].size();
}
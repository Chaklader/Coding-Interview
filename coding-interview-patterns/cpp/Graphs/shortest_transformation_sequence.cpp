#include <string>
#include <vector>
#include <deque>
#include <unordered_set>

int shortestTransformationSequence(std::string& start, std::string& end, std::vector<std::string>& dictionary) {
    std::unordered_set<std::string> dictionarySet(dictionary.begin(), dictionary.end());
    if (dictionarySet.find(start) == dictionarySet.end() || dictionarySet.find(end) == dictionarySet.end()) {
        return 0;
    }
    if (start == end) {
        return 1;
    }
    std::string lowerCaseAlphabet = "abcdefghijklmnopqrstuvwxyz";
    std::deque<std::string> queue;
    queue.push_back(start);
    std::unordered_set<std::string> visited;
    visited.insert(start);
    int dist = 0;
    // Use level-order traversal to find the shortest path from the 
    // start word to the end word.
    while (!queue.empty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            std::string currWord = queue.front();
            queue.pop_front();
            // If we found the end word, we've reached it via the 
            // shortest path.
            if (currWord == end) {
                return dist + 1;
            }
            // Generate all possible words that have a one-letter difference 
            // to the current word.
            for (int j = 0; j < currWord.length(); j++) {
                for (char c : lowerCaseAlphabet) {
                    std::string nextWord = currWord;
                    nextWord[j] = c;
                    // If 'nextWord' exists in the dictionary, it's a 
                    // neighbor of the current word. If unvisited, add it 
                    // to the queue to be processed in the next level.
                    if (dictionarySet.find(nextWord) != dictionarySet.end() && visited.find(nextWord) == visited.end()) {
                        visited.insert(nextWord);
                        queue.push_back(nextWord);
                    }
                }
            }
        }
        dist++;
    }
    // If there is no way to reach the end word, then no path exists.
    return 0;
}
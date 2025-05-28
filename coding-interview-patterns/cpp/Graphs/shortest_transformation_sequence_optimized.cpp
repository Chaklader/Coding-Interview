#include <string>
#include <vector>
#include <deque>
#include <unordered_set>

int shortestTransformationSequenceOptimized(std::string& start, std::string& end, std::vector<std::string>& dictionary) {
    std::unordered_set<std::string> dictionarySet(dictionary.begin(), dictionary.end());
    if (dictionarySet.find(start) == dictionarySet.end() || dictionarySet.find(end) == dictionarySet.end()) {
        return 0;
    }
    if (start == end) {
        return 1;
    }
    std::deque<std::string> startQueue;
    startQueue.push_back(start);
    std::unordered_set<std::string> startVisited;
    startVisited.insert(start);
    std::deque<std::string> endQueue;
    endQueue.push_back(end);
    std::unordered_set<std::string> endVisited;
    endVisited.insert(end);
    int levelStart = 0, levelEnd = 0;
    // Perform a level-order traversal from the start word and another 
    // from the end word.
    while (!startQueue.empty() && !endQueue.empty()) {
        // Explore the next level of the traversal that starts from the 
        // start word. If it meets the other traversal, the shortest 
        // path between 'start' and 'end' has been found. 
        levelStart++;
        if (exploreLevel(startQueue, startVisited, endVisited, dictionarySet)) {
            return levelStart + levelEnd + 1;
        }
        // Explore the next level of the traversal that starts from the 
        // end word.
        levelEnd++;
        if (exploreLevel(endQueue, endVisited, startVisited, dictionarySet)) {
            return levelStart + levelEnd + 1;
        }
    }
    // If the traversals never met, then no path exists.
    return 0;
}

// This function explores the next level in the level-order traversal
// and checks if two searches meet.
bool exploreLevel(std::deque<std::string>& queue, std::unordered_set<std::string>& visited,
                  std::unordered_set<std::string>& otherVisited,
                  std::unordered_set<std::string>& dictionarySet) {
    std::string lowerCaseAlphabet = "abcdefghijklmnopqrstuvwxyz";
    int size = queue.size();
    for (int unused = 0; unused < size; unused++) {
        std::string currentWord = queue.front();
        queue.pop_front();
        for (int i = 0; i < currentWord.length(); i++) {
            for (char c : lowerCaseAlphabet) {
                std::string nextWord = currentWord;
                nextWord[i] = c;
                // If 'nextWord' has been visited during the other 
                // traversal, it means both searches have met.
                if (otherVisited.find(nextWord) != otherVisited.end()) {
                    return true;
                }
                if (dictionarySet.find(nextWord) != dictionarySet.end() && visited.find(nextWord) == visited.end()) {
                    visited.insert(nextWord);
                    queue.push_back(nextWord);
                }
            }
        }
    }
    // If no word has been visited by the other traversal, the searches 
    // have not met yet.
    return false;
}
#include <vector>
#include <string>
#include <unordered_map>
#include <queue>
#include <algorithm>

std::vector<std::string> kMostFrequentStringsMinHeap(std::vector<std::string>& strs, int k) {
    std::unordered_map<std::string, int> freqs;
    for (auto& str : strs) {
        freqs[str]++;
    }
    // Since this is a min-heap comparator, we can use the same 
    // comparator as the one used in the max-heap, but reversing the 
    // inequality signs to invert the priority.
    auto cmp = [](std::pair<int, std::string>& a, std::pair<int, std::string>& b) {
        if (a.first == b.first) {
            return a.second < b.second; 
        }
        return a.first > b.first; 
    };
    std::priority_queue<
        std::pair<int, std::string>,
        std::vector<std::pair<int, std::string>>,
        decltype(cmp)
    > minHeap(cmp);
    for (auto& entry : freqs) {
        minHeap.push(std::make_pair(entry.second, entry.first));
        // If heap size exceeds 'k', pop the lowest frequency string to 
        // ensure the heap only contains the 'k' most frequent words so 
        // far.
        if (minHeap.size() > k) {
            minHeap.pop();
        }
    }
    // Return the 'k' most frequent strings by popping the remaining 'k' 
    // strings from the heap. Since we're using a min-heap, we need to 
    // reverse the result after popping the elements to ensure the most 
    // frequent strings are listed first.
    std::vector<std::string> res;
    for (int i = 0; i < k && !minHeap.empty(); i++) {
        res.push_back(minHeap.top().second);
        minHeap.pop();
    }
    std::reverse(res.begin(), res.end());
    return res;
}
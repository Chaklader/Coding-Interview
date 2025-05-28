#include <vector>
#include <string>
#include <unordered_map>
#include <queue>

std::vector<std::string> kMostFrequentStringsMaxHeap(std::vector<std::string>& strs, int k) {
    // Create a hash map that counts the frequency of each string.
    std::unordered_map<std::string, int> freqs;
    for (auto& str : strs) {
        freqs[str]++;
    }
    // Define a custom comparator for the priority queue. 
    auto cmp = [](std::pair<int, std::string>& a, std::pair<int, std::string>& b) {
        // Prioritize lexicographical order for strings with equal 
        // frequencies. 
        if (a.first == b.first) {
            return a.second > b.second;
        }
        // Otherwise, prioritize strings with higher frequencies.
        return a.first < b.first;
    }; 
    // Create the max heap using the comparator and push all 
    // frequency-string pairs into the heap. Take note that 
    // std::priority_queue is inherently a max-heap.
    std::priority_queue<std::pair<int, std::string>,
                        std::vector<std::pair<int, std::string>>,
                        decltype(cmp)> maxHeap(cmp);
    for (auto& entry : freqs) {
        maxHeap.push(std::make_pair(entry.second, entry.first));
    }
    // Pop the most frequent string off the heap 'k' times and return 
    // these 'k' most frequent strings.
    std::vector<std::string> res;
    for (int i = 0; i < k && !maxHeap.empty(); i++) {
        res.push_back(maxHeap.top().second);
        maxHeap.pop();
    }
    return res;
}
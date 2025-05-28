#include <string>
#include <vector>
#include <unordered_map>

std::vector<std::string> phoneKeypadCombinations(std::string& digits) {
    std::unordered_map<char, std::string> keypadMap = {
        {'2', "abc"}, {'3', "def"}, {'4', "ghi"}, {'5', "jkl"},
        {'6', "mno"}, {'7', "pqrs"}, {'8', "tuv"}, {'9', "wxyz"}
    };
    std::vector<std::string> res;
    if (!digits.empty()) {
        std::string currCombination;
        backtrack(0, currCombination, digits, keypadMap, res);
    }
    return res;
}

void backtrack(int i, std::string& currCombination, std::string& digits, std::unordered_map<char, std::string>& keypadMap, std::vector<std::string>& res) {
    // Termination condition: if all digits have been considered, add the
    // current combination to the output list.
    if (currCombination.size() == digits.size()) {
        res.push_back(currCombination);
        return;
    }
    // Iterate over all letters that the current digit can represent.
    for (char letter : keypadMap.at(digits[i])) {
        // Add the current letter.
        currCombination.push_back(letter);
        // Recursively explore all paths that branch from this combination.
        backtrack(i + 1, currCombination, digits, keypadMap, res);
        // Backtrack by removing the letter we just added.
        currCombination.pop_back();
    }
}
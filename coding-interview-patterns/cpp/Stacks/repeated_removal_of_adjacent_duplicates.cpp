#include <string>
#include <vector>

std::string repeatedRemovalOfAdjacentDuplicates(std::string s) {
    std::vector<char> stack;
    for (char c : s) {
        // If the current character is the same as the top character on the stack,
        // a pair of adjacent duplicates has been formed. So, pop the top character
        // from the stack.
        if (!stack.empty() && c == stack.back()) {
            stack.pop_back();
        }
        // Otherwise, push the current character onto the stack.
        else {
            stack.push_back(c);
        }
    }
    // Return the remaining characters as a string.
    return std::string(stack.begin(), stack.end());
}
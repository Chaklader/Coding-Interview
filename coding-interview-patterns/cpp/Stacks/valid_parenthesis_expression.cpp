#include <string>
#include <unordered_map>
#include <vector>

bool validParenthesisExpression(std::string s) {
    std::unordered_map<char, char> parenthesesMap = {{'(', ')'}, {'{', '}'}, {'[', ']'}};
    std::vector<char> stack;
    for (char c : s) {
        // If the current character is an opening parenthesis, push it 
        // onto the stack.
        if (parenthesesMap.find(c) != parenthesesMap.end()) {
            stack.push_back(c);
        }
        // If the current character is a closing parenthesis, check if 
        // it closes the opening parenthesis at the top of the stack.
        else {
            if (!stack.empty() && parenthesesMap[stack.back()] == c) {
                stack.pop_back();
            }
            else {
                return false;
            }
        }
    }
    // If the stack is empty, all opening parentheses were successfully 
    // closed.
    return stack.empty();
}
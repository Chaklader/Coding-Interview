function isPalindromeValid(s: string): boolean {
    let left = 0, right = s.length - 1;
    while (left < right) {
        // Skip non-alphanumeric characters from the left. 
        while (left < right && !isAlphaNumeric(s[left]))
            left++;
        // Skip non-alphanumeric characters from the right.
        while (left < right && !isAlphaNumeric(s[right]))
            right--;
        // If the characters at the left and right pointers don't
        // match, the string is not a palindrome.
        if (s[left] !== s[right])
            return false;
        left++;
        right--;
    }
    return true;
}

const isAlphaNumeric = (c: string): boolean => /^[a-z0-9]+$/i.test(c);

public class IsPalindromeValid {

    public boolean isPalindromeValid(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            // Skip non-alphanumeric characters from the left.
            // Note: isLetterOrDigit() can't handle characters that could not be represented in the original 16-bit design of Unicode.
            // e.g. emoji characters
            // Note: str.charAt returns value of the string at the specified index. The data type is char.
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Skip non-alphanumeric characters from the right.
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            // If the characters at the left and right pointers don't match, the string is not a palindrome.
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

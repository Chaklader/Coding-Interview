import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithUniqueCharsOptimized {
    public int longestSubstringWithUniqueCharsOptimized(String s) {
        int maxLen = 0;
        Map<Character, Integer> prevIndexes = new HashMap<>();
        int left, right;
        left = right = 0;
        while (right < s.length()) {
            // If a previous index of the current character is present
            // in the current window, it's a duplicate character in the
            // window.
            if (prevIndexes.containsKey(s.charAt(right)) && prevIndexes.get(s.charAt(right)) >= left) {
                // Shrink the window to exclude the previous occurrence
                // of this character.
                left = prevIndexes.get(s.charAt(right)) + 1;
            }
            // Update 'maxLen' if the current window is larger.
            maxLen = Math.max(maxLen, right - left + 1);
            prevIndexes.put(s.charAt(right), right);
            // Expand the window.
            right++;
        }
        return maxLen;
    }
}

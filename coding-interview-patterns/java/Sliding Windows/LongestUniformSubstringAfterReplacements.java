import java.util.HashMap;
import java.util.Map;

public class LongestUniformSubstringAfterReplacements {
    public int longestUniformSubstringAfterReplacements(String s, int k) {
        Map<Character, Integer> freqs = new HashMap<>();
        int highestFreq = 0;
        int maxLen = 0;
        int left, right;
        left = right = 0;
        while (right < s.length()) {
            // Update the frequency of the character at the right pointer 
            // and the highest frequency for the current window.
            freqs.put(s.charAt(right), freqs.getOrDefault(s.charAt(right), 0) + 1);
            highestFreq = Math.max(highestFreq, freqs.get(s.charAt(right)));
            // Calculate replacements needed for the current window.
            int numCharsToReplace = (right - left + 1) - highestFreq;
            // Slide the window if the number of replacements needed exceeds 
            // 'k'. The right pointer always gets advanced, so we just need 
            // to advance 'left'.
            if (numCharsToReplace > k) {
                // Remove the character at the left pointer from the hash map 
                // before advancing the left pointer.
                freqs.put(s.charAt(left), freqs.get(s.charAt(left)) - 1);
                left++;
            }
            // Since the length of the current window increases or stays the 
            // same, assign  the length of the current window to 'maxLen'.
            maxLen = right - left + 1;
            // Expand the window.
            right++;
        }
        return maxLen;
    }
}

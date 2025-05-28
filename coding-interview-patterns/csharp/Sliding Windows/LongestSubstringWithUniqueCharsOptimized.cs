public class Solution
{
    public int LongestSubstringWithUniqueCharsOptimized(string s)
    {
        int maxLen = 0;
        Dictionary<char, int> prevIndices = new Dictionary<char, int>();
        int left = 0, right = 0;

        while (right < s.Length)
        {
            // If a previous index of the current character is present
            // in the current window, it's a duplicate character in the
            // window. 
            if (prevIndices.ContainsKey(s[right]) && prevIndices[s[right]] >= left)
                // Shrink the window to exclude the previous occurrence
                // of this character.
                left = prevIndices[s[right]] + 1;

            // Update 'maxLen' if the current window is larger.
            maxLen = Math.Max(maxLen, right - left + 1);

            prevIndices[s[right]] = right;

            // Expand the window.
            right++;
        }

        return maxLen;
    }
}

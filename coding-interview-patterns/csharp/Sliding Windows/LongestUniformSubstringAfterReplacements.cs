public class Solution
{
    public int LongestUniformSubstringAfterReplacements(string s, int k)
    {
        Dictionary<char, int> freqs = new Dictionary<char, int>();
        int highestFreq = 0, maxLen = 0;
        int left = 0, right = 0;

        while (right < s.Length)
        {
            // Update the frequency of the character at the right pointer 
            // and the highest frequency for the current window.
            freqs[s[right]] = freqs.GetValueOrDefault(s[right], 0) + 1;
            highestFreq = Math.Max(highestFreq, freqs[s[right]]);

            // Calculate replacements needed for the current window.
            int numOfCharsToReplace = (right - left + 1) - highestFreq;

            // Slide the window if the number of replacements needed exceeds 
            // 'k'. The right pointer always gets advanced, so we just need 
            // to advance 'left'.
            if (numOfCharsToReplace > k)
            {
                // Remove the character at the left pointer from the hash map 
                // before advancing the left pointer.
                freqs[s[left]]--;
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

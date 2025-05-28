public class Solution
{
    public int LongestSubstringWithUniqueChars(string s)
    {
        int maxLen = 0;
        ISet<char> uniqueChars = new HashSet<char>();
        int left = 0, right = 0;

        while (right < s.Length)
        {
            // If we encounter a duplicate character in the window, shrink 
            // the window until it's no longer a duplicate.
            while (uniqueChars.Contains(s[right]))
            {
                uniqueChars.Remove(s[left]);
                left++;
            }

            // Once there are no more duplicates in the window, update
            // 'maxLen' if the current window is larger.
            maxLen = Math.Max(maxLen, right - left + 1);

            uniqueChars.Add(s[right]);

            // Expand the window.
            right++;
        }

        return maxLen;
    }
}

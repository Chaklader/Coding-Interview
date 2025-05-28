public class Solution
{
    public int SubstringAnagrams(string s, string t)
    {
        int lenS = s.Length, lenT = t.Length;

        if (lenT > lenS)
            return 0;

        int count = 0;

        int[] expectedFreqs = new int[26];
        int[] windowFreqs = new int[26];

        // Populate 'expectedFreqs' with the characters in string 't'.
        foreach (char ch in t)
            expectedFreqs[ch - 'a']++;

        int left = 0, right = 0;

        while (right < lenS)
        {
            // Add the character at the right pointer to 'windowFreqs'
            // before sliding the window.
            windowFreqs[s[right] - 'a']++;

            // If the window has reached the expected fixed length, we 
            // advance the left pointer as well as the right pointer to 
            // slide the window.
            if (right - left + 1 == lenT)
            {
                if (windowFreqs.SequenceEqual(expectedFreqs))
                    count++;

                // Remove the character at the left pointer from 
                // 'windowFreqs' before advancing the left pointer.
                windowFreqs[s[left] - 'a']--;
                left++;
            }

            right++;
        }

        return count;
    }
}

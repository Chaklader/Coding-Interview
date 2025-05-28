def longest_palindrome_in_a_string(s: str) -> str:
    n = len(s)
    if n == 0:
        return ""
    dp = [[False] * n for _ in range(n)]
    max_len = 1
    start_index = 0
    # Base case: a single character is always a palindrome.
    for i in range(n):
        dp[i][i] = True
    # Base case: a substring of length two is a palindrome if both  
    # characters are the same.
    for i in range(n - 1):
        if s[i] == s[i + 1]:
            dp[i][i + 1] = True
            max_len = 2
            start_index = i
    # Find palindromic substrings of length 3 or greater.
    for substring_len in range(3, n + 1):
        # Iterate through each substring of length 'substring_len'.
        for i in range(n - substring_len + 1):
            j = i + substring_len - 1
            # If the first and last characters are the same, and the 
            # inner substring is a palindrome, then the current 
            # substring is a palindrome.
            if s[i] == s[j] and dp[i + 1][j - 1]:
                dp[i][j] = True
                max_len = substring_len
                start_index = i
    return s[start_index : start_index + max_len]

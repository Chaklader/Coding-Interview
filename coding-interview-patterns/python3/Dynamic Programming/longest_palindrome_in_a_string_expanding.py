from typing import Tuple


def longest_palindrome_in_a_string_expanding(s: str) -> str:
    n = len(s)
    start, max_len = 0, 0
    for center in range(n):
        # Check for odd-length palindromes.
        odd_start, odd_length = expand_palindrome(center, center, s)
        if odd_length > max_len:
            start = odd_start
            max_len = odd_length
        # Check for even-length palindromes.
        if center < n - 1 and s[center] == s[center + 1]:
            even_start, even_length = expand_palindrome(center, center + 1, s)
            if even_length > max_len:
                start = even_start
                max_len = even_length
    return s[start : start + max_len]

# Expands outward from the center of a base case to identify the start 
# index and length of the longest palindrome that extends from this 
# base case.
def expand_palindrome(left: int, right: int, s: str) -> Tuple[int, int]:
    while left > 0 and right < len(s) - 1 and s[left - 1] == s[right + 1]:
        left -= 1
        right += 1
    return left, right - left + 1

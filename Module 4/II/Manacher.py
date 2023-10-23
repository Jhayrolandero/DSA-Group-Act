def longest_palindromic_substring(s):
    # Preprocess the input string to handle even-length palindromes
    processed_s = '#'.join('^{}$'.format(s))

    n = len(processed_s)
    p = [0] * n  # Array to store the palindrome lengths
    center, right = 0, 0

    for i in range(1, n - 1):
        if i < right:
            mirror = 2 * center - i  # Find the mirror position of i

            # Update p[i] using previously computed values
            p[i] = min(right - i, p[mirror])

        # Attempt to expand palindrome centered at i
        a, b = i + (1 + p[i]), i - (1 + p[i])

        while processed_s[a] == processed_s[b]:
            p[i] += 1
            a += 1
            b -= 1

        # If palindrome centered at i expands past right,
        # adjust center and right based on expanded palindrome
        if i + p[i] > right:
            center, right = i, i + p[i]

    # Find the maximum element in p
    max_len, center_index = max((n, i) for i, n in enumerate(p))

    # Extract and return the longest palindromic substring
    start = (center_index - max_len) // 2
    return s[start: start + max_len]


# Example usage:
s = "babad"
result = longest_palindromic_substring(s)
print(f"String: {s}")
print("Longest Palindromic Substring:", result)

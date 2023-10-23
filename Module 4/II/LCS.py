def longest_common_subsequence(X, Y):
    m = len(X)
    n = len(Y)

    # Create a table to store the lengths of LCS for subproblems
    lcs_table = [[0] * (n + 1) for _ in range(m + 1)]

    # Build the lcs_table in a bottom-up manner
    for i in range(m + 1):
        for j in range(n + 1):
            if i == 0 or j == 0:
                lcs_table[i][j] = 0
            elif X[i - 1] == Y[j - 1]:
                lcs_table[i][j] = 1 + lcs_table[i - 1][j - 1]
            else:
                lcs_table[i][j] = max(lcs_table[i - 1][j], lcs_table[i][j - 1])

    # The length of the LCS is stored in lcs_table[m][n]
    lcs_length = lcs_table[m][n]

    # Reconstruct the LCS from the table
    lcs = [''] * (lcs_length + 1)
    lcs[lcs_length] = ''

    i, j = m, n
    while i > 0 and j > 0:
        if X[i - 1] == Y[j - 1]:
            lcs[lcs_length - 1] = X[i - 1]
            i -= 1
            j -= 1
            lcs_length -= 1
        elif lcs_table[i - 1][j] > lcs_table[i][j - 1]:
            i -= 1
        else:
            j -= 1

    return ''.join(lcs)


# Example usage:
X = "AGGTAB"
Y = "GXTXAYB"
result = longest_common_subsequence(X, Y)
print(f"Text: {X}\nPattern: {Y}")
print(f"Pattern found at positions: {result}")

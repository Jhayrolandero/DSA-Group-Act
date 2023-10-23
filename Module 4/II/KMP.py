def compute_partial_match_table(pattern):
    table = [0] * len(pattern)
    length = 0
    i = 1

    while i < len(pattern):
        if pattern[i] == pattern[length]:
            length += 1
            table[i] = length
            i += 1
        else:
            if length != 0:
                length = table[length - 1]
            else:
                table[i] = 0
                i += 1

    return table


def kmp_search(text, pattern):
    table = compute_partial_match_table(pattern)
    i, j = 0, 0
    occurrences = []

    while i < len(text):
        if pattern[j] == text[i]:
            i += 1
            j += 1

            if j == len(pattern):
                occurrences.append(i - j)
                j = table[j - 1]
        else:
            if j != 0:
                j = table[j - 1]
            else:
                i += 1

    return occurrences


# Example usage:
text = "ABABDABACDABABCABAB"
pattern = "ABABCABAB"
result = kmp_search(text, pattern)
print(f"Text: {text}\nPattern: {pattern}")
print(f"Pattern found at positions: {result}")

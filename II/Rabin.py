def rabin_karp(text, pattern):
    def calculate_hash(s, length):
        hash_value = 0
        for i in range(length):
            hash_value = (hash_value * base + ord(s[i])) % prime
        return hash_value

    def rehash(prev_hash, prev_char, next_char, length):
        prev_char_hash = (ord(prev_char) * (base ** (length - 1))) % prime
        new_hash = (prev_hash - prev_char_hash) * base + ord(next_char)
        return new_hash % prime

    def check_match(text, pattern, start):
        for i in range(len(pattern)):
            if text[start + i] != pattern[i]:
                return False
        return True

    prime = 101  # A prime number to reduce hash collisions
    base = 256  # The number of possible characters (ASCII)

    text_length = len(text)
    pattern_length = len(pattern)
    pattern_hash = calculate_hash(pattern, pattern_length)
    text_hash = calculate_hash(text, pattern_length)

    matches = []

    for i in range(text_length - pattern_length + 1):
        if text_hash == pattern_hash and check_match(text, pattern, i):
            matches.append(i)

        if i < text_length - pattern_length:
            text_hash = rehash(
                text_hash, text[i], text[i + pattern_length], pattern_length)

    return matches


# Example usage:
text = "ABABCABABDABABCABABCABAB"
pattern = "ABABCABAB"
result = rabin_karp(text, pattern)
print(f"Text: {text}\nPattern: {pattern}")
print(f"Pattern found at positions: {result}")

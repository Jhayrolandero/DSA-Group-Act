def is_palindrome(s):
    # Helper func
    return s == s[::-1]


def find_palindromes(input_str):
    input_str = input_str.replace(" ", "").lower()

    # Store list
    palindromes = []

    for i in range(len(input_str)):
        for j in range(i + 1, len(input_str) + 1):
            substring = input_str[i:j]

            # Check if palindrome and not empty
            if is_palindrome(substring) and len(substring) > 1:
                palindromes.append(substring)

    return palindromes


input_string = ["Keyer", "RaMmadan", "reverse"]
for str in input_string:
    result = find_palindromes(str)
    print(f"{str}: {result}")

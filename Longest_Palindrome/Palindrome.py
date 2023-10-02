def find_palindromes(word):
    palindrome_list = []

    for i in range(len(word)):
        right_pointer = i + 1
        left_pointer = i - 1

        if left_pointer < 0 or right_pointer >= len(word):
            continue

        if word[left_pointer] != word[right_pointer]:
            if palindrome:
                palindrome_list.append(palindrome)
                palindrome = ""
            continue

        palindrome = word[left_pointer:right_pointer + 1]

    return palindrome_list


def main():
    word = "keyer"
    palindromes = find_palindromes(word)
    print(palindromes)


if __name__ == "__main__":
    main()

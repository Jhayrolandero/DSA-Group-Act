def is_palindrome(word):

    word = word.replace(" ", "").lower()
    return word == word[::-1]


str1 = "radar"
str2 = "MaDAm"
str3 = "armor"

print(f"{str1}: {is_palindrome(str1)}")
print(f"{str2}: {is_palindrome(str2)}")
print(f"{str3}: {is_palindrome(str3)}")

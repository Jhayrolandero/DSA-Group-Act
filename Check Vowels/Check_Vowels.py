def count_vowels(word1: str) -> str:
    vowels = "AEIUOaeiou"
    count = 0
    for char in word1:
        if char in vowels:
            count += 1

    return count


print(count_vowels("eEiUoOOavaAzA"))

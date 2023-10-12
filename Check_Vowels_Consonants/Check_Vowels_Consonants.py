def count_vowels_consonants(word: str) -> str:
    word = word.lower()
    
    vowels = "aeiou"
    consonants = "bcdfghjklmnpqrstvwxyz"
    
    vCount = 0
    cCount = 0
    
    for char in word:
        if char in vowels:
            vCount += 1
            continue
        
        if char in consonants:
            cCount += 1

    return vCount, cCount



word = "eEiUoOOavaAzA"
vCount, cCount = count_vowels_consonants(word=word)
print(f"The given word is {word}")

print(f"Vowel: {vCount}")
print(f"Consonant: {cCount}")
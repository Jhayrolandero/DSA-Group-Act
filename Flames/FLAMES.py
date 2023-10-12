
# Cross out all similar letters then count the length of what left
def check_dup_letter(word1: str, word2: str) -> list:

    word1 = word1.replace(" ", "").lower()
    word2 = word2.replace(" ", "").lower()
    
    count1 = sum(1 for let in word1 if let not in word2)
    count2 = sum(1 for let in word2 if let not in word1)

    return count1 + count2

def what_flames(word1: str, word2: str) -> str:

    # The length determine wether what it is in flames
    count = (check_dup_letter(word1=word1, word2=word2)) % 6

    # i will tokenize the FLAMES into number
    # 1 = F, 2 = L and so on

    flames = {
        1: "Friends",
        2: "LDR",
        3: "Acquaintances",
        4: "Married",
        5: "Enemies",
        0: "Strangers"
    }

    return flames[count]


# Add user input na lang if gusto
print(what_flames("Jose rizal", "melchora aquino"))
print(what_flames("Scooby", "Shaggy"))
print(what_flames("ALICE", "BOB"))


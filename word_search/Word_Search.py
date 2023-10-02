import random
from nltk.corpus import words
import nltk
import string
import re

# Download this first uncomment it
# nltk.download('words')

# Random word generator that don't make sense


def make_random_strings(min_length, max_length):
    length = random.randint(min_length, max_length)
    characters = string.ascii_letters + string.digits + string.punctuation
    return ''.join(random.choice(characters) for _ in range(length))


def randomize_words():

    # Get the list of English words from the NLTK dataset
    word_list = words.words()

    # Get random 100 words from the dataset
    word_list = random.sample(word_list, 100)

    # Get 100 random string from our random words creator
    random_strings = [make_random_strings(5, 15) for _ in range(100)]

    # Add it to our word list
    word_list.extend(random_strings)

    # Generate a list of 100 random words
    random_words = random.sample(word_list, 100)

    return random_words


def make_matrix():

    # Get the random words
    random_words = randomize_words()

    # make the 10 x 10 matrix
    matrix = []
    rows = 10
    columns = 10

    # Make the word search matrix
    for i in range(rows):
        row = []
        for j in range(columns):
            row.append(random_words[i * columns + j])
        matrix.append(row)

    return matrix


word_search = make_matrix()

title = f"""
{'=' * 170}
{'WORD SEARCH'.center(170)}
{'=' * 170}
"""

while (True):
    print(title)
    for i in range(10):
        formatted_row = [word.ljust(15) for word in word_search[i]]
        print(formatted_row, "\n")

    answer = input("\nEnter the word you find in the matrix: ")

    found = False
    index = -1

    # Iterate through the matrix to check if answer is present
    for i, row in enumerate(word_search):
        # Use regex to identify if it's a word
        if re.search(r'[!@#$%^&*()_+{}\[\]:;<>,.?~\\/\|=`]', answer) or re.search(r'\d', answer):
            found = False
            print("Nope! that's not a word")
            break

        for j, word in enumerate(row):
            if answer.lower() == word.lower():
                row_index = i
                column_index = j
                found = True
                break

        # Check if the answer was found
        if found:
            print(
                f"That's correct! The word '{answer.lower()}' was found at index({row_index+1}, {column_index+1})")
            break
        else:
            print("There is no such word")
            break

    choice = input("\nEnter to continue, 'quit' to exit: ")

    if choice == "quit":
        break

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


def check_answer(answer, word_search):
    found = False
    row_index = -1
    column_index = -1

    # Check if the answer contains special characters or digits because it's not a word
    if re.search(r'[!@#$%^&*()_+{}\[\]:;<>,.?~\\/\|=`0-9]', answer):
        print("Nope! That's not a word")
        return

    for i, row in enumerate(word_search):
        for j, word in enumerate(row):
            if answer.lower() == word.lower():
                row_index = i
                column_index = j
                found = True
                break

        if found:
            print(
                f"That's correct! The word '{answer.lower()}' is located at index ({row_index+1}, {column_index+1})")
            return

    # Print this message only if the word is not found
    print("There is no such word")


def print_word_search(word_search):
    for i in range(10):
        formatted_row = [word.ljust(15) for word in word_search[i]]
        print(formatted_row)


if __name__ == "__main__":

    word_search = make_matrix()
    title = f"""
    {'=' * 170}
    {'WORD SEARCH'.center(170)}
    {'=' * 170}
    """

    while True:
        print(title)
        print_word_search(word_search)

        answer = input("\nEnter the word you find in the matrix: ")
        check_answer(answer=answer, word_search=word_search)

        choice = input("\nEnter to continue, 'quit' to exit: ")
        if choice == "quit":
            break

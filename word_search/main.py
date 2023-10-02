import random
import string

# Function to generate a random string of variable length


def random_variable_length_string(min_length, max_length):
    length = random.randint(min_length, max_length)
    characters = string.ascii_letters + string.digits + string.punctuation
    return ''.join(random.choice(characters) for _ in range(length))


# Generate 10 random strings with lengths between 5 and 15 characters
random_strings = [random_variable_length_string(5, 15) for _ in range(10)]

# Print the list of random strings
for string in random_strings:
    print(string)

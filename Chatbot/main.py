import json
import random
import tensorflow
import tflearn
import numpy
import nltk
from nltk.stem.lancaster import LancasterStemmer

stemmer = LancasterStemmer()


with open("intents.json") as file:
    data = json.load(file)

print(data)

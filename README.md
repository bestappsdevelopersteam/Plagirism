# Plagirism
Project2022
------------
Authorship detection is the process of algorithmic identification of the author of an anonymous text. 
The main idea is to extract various statistics from the text (so-called features in the context of Machine Learning) 
in order to form a linguistic signature for each text.
One example of a feature is the average number of words in a sentence.
Having the linguistic signatures of two texts (ie a series of numbers, each of which corresponds to the value of a feature), 
we can determine the similarity between them and calculate the probability that they were written by the same author.
Automated authorship detection is now an area of ​​active research interest and has applications in plagiarism detection, 
email filtering, social science research, and even case law. The specific task was inspired by a programming course
at the Faculty of Computer Science at the University of Toronto.
We will use the following features to identify the author of a text:
Average word length - the average number of characters per word after stripping punctuation.
Type-Token Ratio - the number of all different words used in the text divided by the number of all words. 
Measures how repetitive the vocabulary is.
Hapax Legomena Ratio - the number of words that occur only once in a text divided by the number of all words.
Average number of words in a sentence - the number of all words used in the text divided by the number of sentences.
The program accepts text, derives the values ​​of its features, accepts a second text, also derives the values of 
its features and then derives a result of similarity between the two texts.
The result of similarity is calculated by the formula:
abs (F2T1-F2T2) * 33 + abs (F3T1-F3T2) * 50 + abs (F4T1-F4T2) * 0.4, where F1T1 is feature 1 (average word length) for text 1,
F1T2 is feature 1 for text 2, F2T1 is feature 2 (type-token ratio) for text 1, etc. The numbers 11, 33, 50, 0.4 are weights.
Maked the program can easily change it.

# Objective

This is a project to find and print the 3 longest palindromes within a given string. It comes with a built in application which one can run from the command line or IDE of choice.

# Running the project

After cloning or downloading this repository, from a terminal:

`sbt run {string}`

ie.

`sbt run sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop`

# Running tests

From the project's folder on a terminal:

`sbt test`

# Versions
This project has been developed and tested using the following versions:

- SBT: 0.13.8
- Scala: 2.11.7

---

# Exercise Instructions

## Task
Write an application that finds the 3 longest unique palindromes in a supplied string. For the 3 longest palindromes, report the palindrome, start index and length, in descending order of length.

## Example Output
Given the input string: sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop , the output should be:
 Text: hijkllkjih, Index: 23, Length: 10
 Text: defggfed, Index: 13, Length: 8
 Text: abccba, Index: 5 Length: 6
 
## Deliverables
- Your solution may be submitted in a language of your choice. 
- Please include instructions for how to build and run your code. 
- Don't forget to include any tests in the package.

## Guidance
- You shouldn't spend more than a couple of hours on the solution.
- We expect candidates to create code that is production quality - the solution should be correct, reliable, maintainable, reusable, portable and efficient.
- For further guidance see Clean Code: A Handbook of Agile Software Craftsmanship by Robert C. Martin.
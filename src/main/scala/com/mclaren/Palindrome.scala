package com.mclaren

case class PalindromeMatch(palindrome: String, index: Int) {
  def length: Int = palindrome.length
}

object PalindromeFinder {

  type Matches = List[PalindromeMatch]

  def find(input: String): Matches = {
    findPalindromes(input)
      .groupBy(_.palindrome)
      .map(_._2.head)
      .toList
      .sortWith(_.length > _.length)
      .take(3)
  }

  private def isPalindrome(input: String): Boolean = {
    if (input.length < 2) false
    else input == input.reverse
  }

  private def findPalindromes(input: String): Matches = {

    def findAllPalindromes(input: String): Matches = {
      (for {
        start <- input.indices
        end <- start to input.length
        if isPalindrome(input.substring(start, end))
      } yield PalindromeMatch(input.substring(start, end), start)).toList
    }

    def removeInnerPalindromes(allMatches: Matches, acc: Matches): Matches = allMatches match {
      case Nil => acc
      case x :: xs => {
        if (acc.exists(p => p.palindrome.contains(x.palindrome))) removeInnerPalindromes(xs, acc)
        else removeInnerPalindromes(xs, x :: acc)
      }
    }

    removeInnerPalindromes(findAllPalindromes(input), List())
  }
}

object PalindromePrinter {
  def print(list: List[PalindromeMatch]): Unit = {
    list.foreach(p =>
      println(s"Text: ${p.palindrome}, Index: ${p.index}, Length: ${p.length}")
    )
  }
}
package com.mclaren

case class PalindromeMatch(palindrome: String, index: Int) {
  def length: Int = palindrome.length
}

object PalindromeFinder {

  private def isPalindrome(input: String): Boolean = {
    if (input.length < 2) false
    else input == input.reverse
  }

  private def findAllPalindromes(input: String): List[PalindromeMatch] = {

    def removeInnerPalindromes(allMatches: List[PalindromeMatch], acc: List[PalindromeMatch]): List[PalindromeMatch] = allMatches match {
      case Nil => acc
      case x :: xs => {
        if (acc.exists(p => p.palindrome.contains(x.palindrome))) removeInnerPalindromes(xs, acc)
        else removeInnerPalindromes(xs, x :: acc)
      }
    }

    val allMatches = (for {
      start <- input.indices
      end <- start to input.length
      if isPalindrome(input.substring(start, end))
    } yield PalindromeMatch(input.substring(start, end), start)).toList

    removeInnerPalindromes(allMatches, List())
  }

  def find(input: String): List[PalindromeMatch] = {
    findAllPalindromes(input)
      .groupBy(_.palindrome)
      .map(_._2.head)
      .toList
      .sortWith(_.length > _.length)
      .take(3)
  }
}

object PalindromePrinter {
  def print(list: List[PalindromeMatch]): Unit = {
    list.foreach(p =>
      println(s"Text: ${p.palindrome}, Index: ${p.index}, Length: ${p.length}")
    )
  }
}
package com.mclaren

import scala.collection.immutable.IndexedSeq

case class PalindromeMatch(palindrome: String, index: Int) {
  def length: Int = palindrome.length
}

object PalindromeFinder {

  private def isPalindrome(input: String): Boolean = {
    if (input.length < 2) false
    else input == input.reverse
  }

  private def findAllPalindromes(input: String): IndexedSeq[PalindromeMatch] = {
    for {
      start <- input.indices
      end <- start to input.length
      if isPalindrome(input.substring(start, end))
    } yield PalindromeMatch(input.substring(start, end), start)
  }

  def find(input: String): List[PalindromeMatch] = {
    findAllPalindromes(input)
      .groupBy(_.palindrome)
      .map(_._2.head)
      .toList
      .sortWith(_.length > _.length)
  }
}

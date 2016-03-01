package com.mclaren

import scala.collection.immutable.IndexedSeq

case class PalindromeMatch(palindrome: String, index: Int)

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

  def find(input: String): IndexedSeq[PalindromeMatch] = {
    findAllPalindromes(input)
  }
}

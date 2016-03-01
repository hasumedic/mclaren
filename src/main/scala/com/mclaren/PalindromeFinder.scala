package com.mclaren

case class PalindromeMatch(palindrome: String, index: Int)

object PalindromeFinder {

  def isPalindrome(input: String): Boolean = {
    if (input.isEmpty) false
    else input == input.reverse
  }

  def find(input: String): List[PalindromeMatch] = {
    if (isPalindrome(input)) List(PalindromeMatch(input, 1))
    else List()
  }
}

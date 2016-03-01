package com.mclaren

case class PalindromeMatch(palindrome: String, index: Int)

object PalindromeFinder {
  def find(input: String): List[PalindromeMatch] = {
    if (input.isEmpty) List()
    else List(PalindromeMatch(input, 1))
  }
}

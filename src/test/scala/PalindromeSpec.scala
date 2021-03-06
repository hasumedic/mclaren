import com.mclaren.{PalindromeMatch, PalindromeFinder}
import org.scalatest._

class PalindromeSpec extends FlatSpec with Matchers {
  "PalindromeFinder" should "find no palindromes in an empty string" in {
    PalindromeFinder.find("") should be(List())
  }

  it should "find a palindrome when the whole word is" in {
    val expected = PalindromeMatch("lol", 0)
    PalindromeFinder.find("lol") should be(List(expected))
  }

  it should "find no palindromes when the are none in the input string" in {
    PalindromeFinder.find("bov") should be(List())
  }

  it should "find a palindrome within the input string" in {
    val expected = PalindromeMatch("lol", 2)
    PalindromeFinder.find("zxlolcv") should be(List(expected))
  }

  it should "find more than one palindrome within an input string" in {
    val expected = List(PalindromeMatch("lol", 2), PalindromeMatch("pup", 7))
    PalindromeFinder.find("zxlolcvpupbn") should be(expected)
  }

  it should "return the list of found palindromes ordered by length in a single palindrome" in {
    val expected = List(PalindromeMatch("qweewq", 0), PalindromeMatch("rttr", 6), PalindromeMatch("yy", 10))
    PalindromeFinder.find("qweewqrttryy") should be(expected)
  }

  it should "return the list of found palindromes ordered by length in different palindromes" in {
    val expected = List(PalindromeMatch("erre", 3), PalindromeMatch("qwq", 0))
    PalindromeFinder.find("qwqerre") should be(expected)
  }

  it should "return unique palindromes" in {
    val expected = List(PalindromeMatch("rtr", 0))
    PalindromeFinder.find("rtrmkjrtr") should be(expected)
  }

  it should "return only the first three elements of the collection of palindromes" in {
    val expected = List(PalindromeMatch("hijkllkjih", 23), PalindromeMatch("defggfed", 13), PalindromeMatch("abccba", 5))
    PalindromeFinder.find("sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop") should be(expected)
  }
}

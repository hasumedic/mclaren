import com.mclaren.{PalindromeMatch, PalindromeFinder}
import org.scalatest._

class PalindromeFinderSpec extends FlatSpec with Matchers {
  "PalindromeFinder" should "find no palindromes in an empty string" in {
    PalindromeFinder.find("") should be (List())
  }

  "PalindromeFinder" should "find a palindrome when the whole word is" in {
    val expected = PalindromeMatch("lol", 1)
    PalindromeFinder.find("lol") should be (List(expected))
  }
}

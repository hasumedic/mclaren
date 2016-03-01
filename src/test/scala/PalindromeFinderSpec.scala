import com.mclaren.PalindromeFinder
import org.scalatest._

class PalindromeFinderSpec extends FlatSpec with Matchers {
  "PalindomeFinder" should "find no palindromes in an empty string" in {
    PalindromeFinder.find("") should be (List())
  }
}

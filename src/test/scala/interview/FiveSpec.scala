package interview

import org.specs2.mutable.Specification

class FiveSpec extends Specification {

    import Five._

    "It" should {
        " pass countBit in 5" in {
            countBit(18) must_==(2)
            countBit(15) must_==(4)
        }

        " pass 5" in {
            five(29, 15) must_==(2)
        }

        " pass *.draw in 8" in {
            draw(1, 6) must_==(0x7E)
        }

        " pass 8" in {
            val input = Array.fill(10)(0)
            val out = Array(0, 0,
                0, 0,
                0, 0,
                0x0F, 0xF0,
                0, 0)

            drawHorizontalLine(input, 16, 4, 11, 3)

            input must_==(out)
        }
    }
}

/*

 http://etorreborre.github.io/specs2/guide/org.specs2.guide.Matchers.html

 ## Matcher

 ### Equality

 * 1 must_== 1
 * 1
 * toTrue
 * toFalse

 ### Any

 * beNull
 * beAsNullAs: when 2 objects must be null at the same time if one of them is null
 * [yas] elisp error: Symbol's value as variable is void: beLike: to check if an object is like a given pattern
 * beOneOf(a, b, c): to check if an object is one of a given list

 ### Option/Either/Try

 * beNone
 * beAsNoneAs
 * beSome(exp):
 * beSome.which(function)
 * beSome.like(partial function)

 * beRight(exp)
 * beRight.like(partial function)
 * beLeft.like(partial function)

 * beSuccessfulTry: checks if an element is Success(_)
 * beSuccessfulTry.withValue(exp) checks if an element is Success(_)
 * beFailedTry
 * beFailedTry.withThrowable[T]

 ### String

 * beMatching (or be matching): checks if a string matches a regular expression
 * =~(s): is a shortcut for beMatching("(.|\s)*"+s+"(.|\s)*")
 * find(exp).withGroups(a, b, c): checks if some groups are found in a string
 * have size(10): checks the size of a string (seen as an Iterable[Char])
 * be empty: checks if a string is empty
 * beEqualTo(b).ignoreSpace.ignoreCase.trimmed
 * contain(b)
 * startWith(b)
 * endWith(b)

 ### Numeric

 * 1 must be_<=(2)
 * 1 must be_<(2)
 * 2 must be_>=(1)
 * 2 must be_>(1)
 * 5 must beBetween(3, 6)

 ### Exception

 * throwA[ExceptionType](message = "boom")
 * throwA[ExceptionType].like { case e => e must matchSomething }
 * throwA(exception).like { case e => e must matchSomething }

 ### Traversable

 Seq() must be empty
 Seq(1, 2, 3) must not be empty
 Seq(1, 2) must have size(2)
 Seq(1, 2, 3) must beSorted
 Seq(1, 2, 3) must contain(2)
 Seq(1, 2, 3) must contain(be_>=(2))

 Seq(1234, 6237) must containMatch("23") // matches with ".*23.*"
 Seq(1234, 6234) must containPattern(".*234") // matches with !.*234"

 Seq(1, 2, 3) must contain(be_>(0)).forall // this will stop after the first failure
 Seq(1, 2, 3) must contain(be_>(0)).foreach // this will report all failures
 Seq(1, 2, 3) must contain(be_>(0)).atLeastOnce
 Seq(1, 2, 3) must contain(be_>(2)).atMostOnce
 Seq(1, 2, 3) must contain(be_>(2)).exactly(1.times)
 Seq(1, 2, 3) must contain(be_>(2)).exactly(1)
 Seq(1, 2, 3) must contain(be_>(1)).between(1.times, 2.times)
 Seq(1, 2, 3) must contain(be_>(1)).between(1, 2)

 Seq(1, 2, 3, 4) must contain(2, 4)
 Seq(1, 2, 3, 4) must contain(allOf(2, 4))
 Seq(1, 2, 3, 4) must contain(allOf(be_>(0), be_>(1)))
 Seq(1, 2, 3, 4) must contain(allOf(be_>(0), be_>(1)).inOrder)
 Seq(1) must contain(allOf(1, 1)).onDistinctValues

 Seq(1, 2, 3, 4) must contain(atLeast(2, 4))
 Seq(2, 3) must contain(atMost(2, 3, 4))
 Seq(1, 2) must contain(exactly(2, 1))

 Seq(2, 4, 1) must containTheSameElementsAs(Seq(1, 4, 2))

 ### Map

 Map(1 -> "1") must haveKey(1)
 Map(1 -> "1", 2 -> "2") must haveKeys(1, 2)
 Map(1 -> "1", 2 -> "2") must haveValue("1", "2")
 Map(1 -> "1") must havePair(1 -> "1")
 Map(1->"1", 2->"2", 3->"3") must havePairs(1->"1", 2->"2")

 */

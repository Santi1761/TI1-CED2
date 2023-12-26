import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

abstract class MyTestClass(entityToTest: String) extends AnyFlatSpec with Matchers {
  behavior of entityToTest
}

class BinarySearchTest extends MyTestClass("A BinarySearch") {
  it should "return the correct list of indices" in {
    val sortedList = List(1, 5, 8, 12, 13)
    val targetList = List(8, 1, 23, 1, 11)

    BinarySearch(sortedList).searchEachIndex(targetList) shouldEqual List(2, 0, -1, 0, -1)
  }

  it should "return the correct list of indices and -1 if not found" in {
    val sortedList = List(1, 5, 8, 12, 13)
    val targetList = List(8, 1, 23, 1, 11)

    BinarySearch(sortedList).searchEachIndex(targetList) shouldEqual List(2, 0, -1, 0, -1)
  }

  it should "return a list of indices not found (-1)" in {
    val sortedList = List(1, 5, 8, 12, 13)
    val targetList = List(12, 13, 8, 1, 5)

    BinarySearch(sortedList).searchEachIndex(targetList) shouldEqual List(3, 4, 2, 0, 1)
  }
}

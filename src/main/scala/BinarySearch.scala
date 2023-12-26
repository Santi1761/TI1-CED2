import scala.annotation.tailrec

case class BinarySearch(sortedList: List[Int]) {
  def searchEachIndex(targetList: List[Int]): List[Int] = targetList match {
    case Nil => Nil
    case first :: rest => binarySearch(first).getOrElse(-1) :: searchEachIndex(rest)
  }

  private def binarySearch(target: Int): Option[Int] = {
    @tailrec
    def binarySearchRecursive(left: Int, right: Int): Option[Int] = {
      if (left > right) None
      else {
        val mid = (left + (right - left) / 2)
        sortedList(mid) match {
          case `target` => Some(mid)
          case x if x < target => binarySearchRecursive(mid + 1, right)
          case _ => binarySearchRecursive(left, mid - 1)
        }
      }
    }
    binarySearchRecursive(0, sortedList.length - 1)
  }
}


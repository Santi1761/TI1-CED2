import scala.annotation.tailrec //Imported to be able to use @tailrec

/**
 * Principal Class, point 3 TI2 CED2
 */
object OrganizingLottery {

  /**
   * Combines two ordered lists of segments into a single ordered list.
   *
   * @param left
   * @param right
   * @return Ordered list combining the 'left' and 'right' segments.
   */
  def merge(left: List[(Int, Int)], right: List[(Int, Int)]): List[(Int, Int)] = (left, right) match {
    case (Nil, m) => m
    case (n, Nil) => n
    case (lHead :: lFoot, rHead :: rFoot) =>
      if (lHead._1 <= rHead._1) lHead :: merge(lFoot, right)
      else rHead :: merge(left, rFoot)
  }

  /**
   * Sorts a list of segments using the MergeSort algorithm.
   *
   * @param input
   * @return A sorted list of segments.
   */
  def mergeSort(input: List[(Int, Int)]): List[(Int, Int)] = {
    val y = input.length
    if (y <= 1) input
    else {
      val (left, right) = input.splitAt(y / 2)
      merge(mergeSort(left), mergeSort(right))
    }
  }

  /**
   * Keeps track of ordered segment events and counts segments containing dots.
   *
   * @param events
   * @param counter
   * @param results
   * @return A list of cumulative counts of segments containing points.
   */
  @tailrec
  def analizeSegments(events: List[(Int, Int)], counter: Int, results: List[Int]): List[Int] = {

    events match {
      case Nil => results
      case (coordinate, eventType) :: tail =>
        val newCount = counter + eventType
        val newResults = if (eventType == 0) {
          results :+ newCount
        } else {
          results
        }
        analizeSegments(tail, newCount, newResults)
    }
  }

  /**
   * Count segments containing points in a list of segments and a list of points.
   *
   * @param segments
   * @param points
   * @return A list of segment counts containing points for each point.
   */
  def segmentsPoints(segments: List[(Int, Int)], points: List[Int]): List[Int] = {

    val sortedSegments = mergeSort(segments)

    val events = sortedSegments.flatMap {
      case (start, end) => List((start, 1), (end + 1, -1))
    } ++ points.map((_, 0))

    val sortedEvents = events.sortBy {
      case (coordinate, _) => (coordinate, -1)
    }

    analizeSegments(sortedEvents, 0, List.empty)
  }

}


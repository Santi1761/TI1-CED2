import scala.annotation.tailrec
object MajorityElement {

  def getFrequency(l: List[Int], elem: Int): Int =
    @tailrec
    def getFrequencyTailRecursive(lst: List[Int], acc: Int): Int =
      lst match
        case Nil => acc
        case h :: t =>
          if (h == elem) getFrequencyTailRecursive(t, acc + 1)
          else getFrequencyTailRecursive(t, acc)

    getFrequencyTailRecursive(l, 0)

  def majorityElem(l: List[Int], min: Int, max: Int): Int =
    (min, max) match
      case (min, _) if min == max => l(min)
      case _ =>
        val k = Math.floor((min + max) / 2).toInt
        val elemLeftSub = majorityElem(l, min, k)
        val elemRightSub = majorityElem(l, k + 1, max)

        if (elemLeftSub == elemRightSub) elemLeftSub

        else
          val leftCount =
            getFrequency(l.slice(min, max + 1), elemLeftSub)
          val rcount =
            getFrequency(l.slice(min, max + 1), elemRightSub)

          if (leftCount > k) elemLeftSub
          else if (rcount > k) elemRightSub
          else -1


  def triggerMajorityElem(l: List[Int]): Int =
    if(l.length == 0) 0
      else
      val result = majorityElem(l, 0, l.length - 1)
      if (result == -1) 0
      else if (getFrequency(l, result) > l.length / 2) 1
      else 0

}
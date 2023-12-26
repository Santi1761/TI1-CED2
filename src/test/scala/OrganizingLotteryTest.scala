/**
 * This class contains unit tests for the OrganizingLottery class.
 * It verifies the correctness of the segmentsPoints function under different scenarios.
 */
import org.scalatest.funsuite.AnyFunSuite

class OrganizingLotteryTest extends AnyFunSuite:

  /**
   * Test 1: Should return [1, 1, 0]
   * Verifies that the segmentsPoints function correctly counts segments containing points.
   */
  test("Prueba 1: Debe retornar 2") {
    val segments = List((0, 7), (5, 10))
    val points = List(1, 6, 11)

    assert(OrganizingLottery.segmentsPoints(segments, points) === List(1, 1, 0))
  }

  /**
   * Test 2: Should return [1]
   * Verifies that the segmentsPoints function correctly counts segments containing points for a single segment and point.
   */
  test("Prueba 2: Debe retornar 1") {
    val segments = List((1, 5))
    val points = List(3)

    assert(OrganizingLottery.segmentsPoints(segments, points) === List(1))
  }

  /**
   * Test 3: Should return [0, 0, 0]
   * Verifies that the segmentsPoints function correctly handles scenarios where no segments contain points.
   */
  test("Prueba 3: Debe retornar 0") {
    val segments = List((1, 5))
    val points = List(0, 6, 7)

    assert(OrganizingLottery.segmentsPoints(segments, points) === List(0, 0, 0))
  }

  /**
   * Test 4: Should return [1, 0, 0]
   * Verifies that the segmentsPoints function correctly counts segments containing points, including cases where no points are inside segments.
   */
  test("Prueba 4: Debe retornar 1,0,0") {
    val segments = List((0, 5), (7, 10))
    val points = List(1, 6, 11)

    assert(OrganizingLottery.segmentsPoints(segments, points) === List(1, 0, 0))
  }


  /**
   * Test 5: Should return [0, 0, 1]
   * Verifies that the segmentsPoints function correctly counts segments containing points, including negative points.
   */
  test("Prueba 5: Debe retornar 0, 0, 1") {
    val segments = List((-10, 10))
    val points = List(-100, 0, 100)

    assert(OrganizingLottery.segmentsPoints(segments, points) === List(0, 0, 1))
  }


  /**
   * Test 6: Should return [2, 0]
   * Verifies that the segmentsPoints function correctly counts segments containing points, including overlapping segments.
   */
  test("Prueba 6: Debe retornar 2,0") {
    val segments = List((0, 5), (-3, 2), (7, 10))
    val points = List(1, 6)

    assert(OrganizingLottery.segmentsPoints(segments, points) === List(2, 0))
  }



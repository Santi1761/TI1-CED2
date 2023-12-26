  import org.scalatest.funsuite.AnyFunSuite

  class MajorityElementTest extends AnyFunSuite:

    test("Prueba 1: Debe retornar 0, ya que es una lista vacía") {
      val l = List()
      assert(MajorityElement.triggerMajorityElem(l) === 0)
    }

    test("Prueba 2: Debe retornar 1") {
      val l1 = List(4)
      assert(MajorityElement.triggerMajorityElem(l1) === 1)
    }

    test("Prueba 3: Debe retornar 0, porque no hay elemento mayor que la mitad") {
      val l2 = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
      assert(MajorityElement.triggerMajorityElem(l2) === 0)
    }

    test("Prueba 4: Debe retornar 0, porque debe ser estrictamente mayor") {
      val l3 = List(3, 1, 2, 3, 3, 4, 2)
      assert(MajorityElement.triggerMajorityElem(l3) === 0)
    }

    test("Prueba 5: Retorna 1") {
      val l4 = List(4, 2, 4, 3, 4, 4, 2, 4)
      assert(MajorityElement.triggerMajorityElem(l4) === 1)
    }

    test("Prueba 6: Debe retornar 1") {
      val l5 = List(7, 7, 7, 5, 1)
      assert(MajorityElement.triggerMajorityElem(l5) === 1)
    }


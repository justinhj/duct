import org.functionaljustin.duct.datatypes.NonEmptyList

class NonEmptyListSuite extends munit.FunSuite {
  test("create various lengths and types of NonEmptyList") {
    // As expected creating an empty NonEmptyList is not allowed
    // and causes a compile error
    // val emptyList = NonEmptyList()
    val oneList = NonEmptyList(1)
    val twoList = NonEmptyList(2,3)
    val threeList = NonEmptyList("four", "five", "six")
    assertEquals(oneList.toList, List(1))
    assertEquals(twoList.toList, List(2,3))
    assertEquals(threeList.toList, List("four", "five", "six"))
  }
  test("append of lists of the same type") {
    val oneList = NonEmptyList(1)
    val twoList = NonEmptyList(2,3)
    val onetwoList = oneList.append(twoList)
    assertEquals(onetwoList.toList, List(1,2,3))
  }
  test("toList") {
    assertEquals(NonEmptyList(1.0,2.0,3.0).toList, List(1.0,2.0,3.0)) 
  }
  test("fromSeq when empty seq") {
    val empty = List.empty[Int]
    assertEquals(NonEmptyList.fromSeq(empty),None) 
  }
  test("fromSeq when not empty seq") {
    val someThings = List(1,2,3,4,5)
    val someThingsNel = NonEmptyList(1,2,3,4,5)
    assertEquals(NonEmptyList.fromSeq(someThings),Some(someThingsNel))
  }
}
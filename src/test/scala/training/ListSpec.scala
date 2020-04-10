package training

import org.scalatest.flatspec.AnyFlatSpec

import scala.collection.mutable.ListBuffer

class ListSpec extends AnyFlatSpec{
  "A List" should "pop values in last-in-first-out order" in {
    val stack : List[Int] = List(1,2)
    assert(stack.head === 1)
    assert(stack.apply(1) === 2)
  }

  it should "add values to a list properly" in {
    val lb = new ListBuffer[Int]
    lb.append(1)
    lb.append(2)
    lb.append(3)
    val list = lb.toList

    assert(list.head === 1)
    assert(list.apply(1) === 2)
    assert(list.apply(2) === 3)
  }

  it should "add values to a list using Listbuffer and += operator" in {
    var lb = new  ListBuffer[Int]
    lb += 1
    lb += 2
    lb += 3

    val list = lb.toList
    assert(list.head === 1)
    assert(list.apply(1) === 2)
    assert(list.apply(2) === 3)
  }

  it should "contains the element added by :: operator in first place" in {
    var lb = new ListBuffer[Int]
    lb += 1
    lb += 2

    val list = lb.toList
    val list2 = 3::list

    assert(list2.head === 3)
    assert(list2.apply(1) === 1)
    assert(list2.apply(2) === 2)
  }

  it should "contain all items from 2 list using ::: operator to concat them" in {
    val list1 = List[Int](1,2,3)
    val list2 = List[Int](4,5,6)
    val list3 = list1 ::: list2

    assert(list3.head === 1)
    assert(list3.apply(1) == 2)
    assert(list3.apply(2) === 3)
    assert(list3.apply(3) === 4)
    assert(list3.apply(4) === 5)
    assert(list3.apply(5) === 6)
  }

  it should "append element should create new list" in {
    val list1 = List[Int](1,2)
    assert((3 :: list1).head === 3)
    assertThrows[IndexOutOfBoundsException](list1.apply(2) === 3)
  }

  it should "map the list properly" in {
    val list1 = List[Int](1,2,3,4)
    val mappedList = list1.map(_+1)
    assert(mappedList.head === 2)
    assert(mappedList.apply(1) === 3)
    assert(mappedList.apply(2) === 4)
    assert(mappedList.apply(3) === 5)
  }

  it should ("flatmap the list properly") in {
    val list1 = List[String]("one,two,three", "four,five,six", "seven,eight,nine")
    val flatMappedList = list1.flatMap(_.split(","))
    assert(flatMappedList.head === "one")
    assert(flatMappedList.apply(1) === "two")
    assert(flatMappedList.apply(2) === "three")
    assert(flatMappedList.apply(3) === "four")
    assert(flatMappedList.apply(8) === "nine")
    assert(flatMappedList.apply(4) === "five")
    assert(flatMappedList.apply(5) === "six")
    assert(flatMappedList.apply(6) === "seven")
    assert(flatMappedList.apply(7) === "eight")
  }

  it should "repeat elements by using fill operation" in {
    val listInt = List.fill(10)(2)
    val expectedList1 = List[Int](2,2,2,2,2,2,2,2,2,2)

    val listString = List.fill(3)("apple");
    val expectedListString = List[String]("apple","apple","apple")

    assert(listInt === expectedList1)
    assert(listString === expectedListString)
    assert(listString.equals(expectedListString))
  }

  it should ("create empty list by using Nil as init value") in {
    val list : List[String] = Nil
    assert(list.isEmpty)
  }
}

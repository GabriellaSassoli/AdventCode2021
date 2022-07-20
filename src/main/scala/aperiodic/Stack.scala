package aperiodic

import scala.collection.mutable.ListBuffer

object Stack extends App {

  // creating a stack from a linked list. Stack has to have pop(), top(), push() of O(1)
  private val myStack: ListBuffer[Int] = ListBuffer.empty

  def push(value: Int): ListBuffer[Int] = myStack += value

  def top(): Int = myStack.last

  def pop(): Int = myStack.remove(myStack.length - 1)

  println(myStack +"\nadding value 1 " + push(1) + "\nadding value 2 " + push(2)+ "\ntop: " + top + " the new stack is: " + myStack + "\ndeliting value" + pop + "the final stack is" + myStack)
}

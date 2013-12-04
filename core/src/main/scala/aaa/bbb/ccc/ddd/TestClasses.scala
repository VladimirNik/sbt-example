package aaa.bbb.ccc.ddd

case class ClassA
case class ClassB

trait TraitC
trait TraitD

object TestObjects {
  val t1 = ClassA()
  val t2 = ClassB()
  
  val t3 = new ClassA() with TraitC with TraitD
}

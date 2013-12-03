object ProductNTest {  
  
  case class Test0(a1: aaa.bbb.ccc.ddd.ClassA, a2: aaa.bbb.ccc.ddd.ClassB)
  
  import aaa.bbb.ccc.ddd._

  case class Test1(v1: ClassA, v2: ClassB)
  
  val t1 = ClassA()
  val t2 = ClassB()
}
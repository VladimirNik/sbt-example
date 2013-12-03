import scala.collection

object TestVals {
    val a0 = new aaa.bbb.ccc.ddd.ClassA()
	val b0 = scala.collection.mutable.Map[aaa.bbb.ccc.ddd.ClassB, aaa.bbb.ccc.ddd.ClassA]()
}

class TestUsage {
  
  val a1 = TestVals.a0
  
  
  
  import aaa.bbb
  val a2 = TestVals.a0

  
  
  import aaa.bbb.{ccc => mod}
  val a3 = TestVals.a0
  
  
  
  import aaa.bbb.ccc.ddd.{ClassA=>NewName, _}
  val a4 = TestVals.a0
  
  
  
  val b1 = TestVals.b0
  
 

  import scala.collection.mutable.Map
  val b2 = TestVals.b0
  
  
  
  import scala.collection.mutable
  import scala.collection.immutable.Map
  val b3 = TestVals.b0
}
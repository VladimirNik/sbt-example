object AbstractImplTraits {
  
  trait Trait1 {
    val x1: aaa.bbb.ccc.ddd.ClassA
    def x2(x: aaa.bbb.ccc.ddd.ClassA): aaa.bbb.ccc.ddd.ClassB
  }

  trait Trait2[T] {
    val y1: T
    def y2(x: T): aaa.bbb.ccc.ddd.ClassA
    def y3[U](x: T=>U)(y: aaa.bbb.ccc.ddd.ClassA): scala.collection.mutable.ArrayBuffer[U]
  }
}

class AbstractImplTraits {
  import AbstractImplTraits._
  import aaa.bbb.ccc.ddd.{ClassA, ClassB}
  
  //class T1 extends Trait1
   
  //class T2 extends Trait2[ClassA]
  
  
}
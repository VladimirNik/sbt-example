import language.experimental.macros
import scala.reflect.macros.Context

object Macros {
  def hello_impl(c: Context) = c.universe.reify(println("hello world!"))
  def hello = macro hello_impl

  
  
  def printf(format: String, params: Any*): Unit = macro printf_impl
  def printf_impl(c: Context)(format: c.Expr[String], params: c.Expr[Any]*): c.Expr[Unit] = {
    import c.universe._
    import scala.collection.mutable.ListBuffer
    import scala.collection.mutable.Stack
    val Literal(Constant(s_format: String)) = format.tree
    val evals = ListBuffer[ValDef]()
    def precompute(value: Tree, tpe: Type): Ident = {
      val freshName = newTermName(c.fresh("eval$"))
      evals += ValDef(Modifiers(), freshName, TypeTree(tpe), value)
      Ident(freshName)
    }
    val paramsStack = Stack[Tree]((params map (_.tree)): _*)
    val refs = s_format.split("(?<=%[\\w%])|(?=%[\\w%])") map {
      case "%d" => precompute(paramsStack.pop, typeOf[Int])
      case "%s" => precompute(paramsStack.pop, typeOf[String])
      case "%%" => Literal(Constant("%"))
      case part => Literal(Constant(part))
    }
    val stats = evals ++ refs.map(ref => reify(print(c.Expr[Any](ref).splice)).tree)
    c.Expr[Unit](Block(stats.toList, Literal(Constant(()))))
  }

  
  
  
  def test1_impl(c: Context) =
    c.universe.reify { 
      val bool = false
      val x = 5
      if (bool) x else bool
      def test[T](x: String) = x
    }
  def test1 = macro test1_impl

  
  
  
  def test2_impl(c: Context)(cond: c.Expr[Boolean], msg: c.Expr[Any]) = c.universe.reify {
      trait Test {
        def testing: Int
      } 
      
      class VVV[U]
      
      final class YYY[T](val a: String, b: Int) extends VVV[T] with Test {
      
        def testing = 7
        
        import scala.collection._
        def test[T](x: Test) = x
        
        val x = 9
      } 
      val a = 7
      val b = new YYY[String]("fff", 5)
      println("hello world!" + b.testing)
  
  }
  def test2(cond: Boolean, msg: Any) = macro test2_impl
}

class TestCats {
  import cats.data.Xor
  import cats.syntax.all._
  import cats.std.all._

  def valida(a: Int): Validated[List[String], Int] = {
    if (a > 0) Validated.valid(a)
    else Validated.invalid(List("That number sucks"))
  }

  val q = valida(4)
  val w = valida(-2)

  q |@| w
}
//CartesianOps[T, Int]
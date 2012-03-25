import hiratara.Statistics._

object Exercise2_3 extends App {
  List(100, 500, 1000, 40000).foreach((n: Int) => println(sturgesRule(n)))
}

import hiratara.Statistics._

object Exercise2_3 extends App {
  List(100, 500, 1000, 40000).foreach((n: Int) => println(sturgesRule(n)))
}

object Exercise2_4 extends App {
  val min = scala.math.floor(5.18 * 10) / 10
  val max = scala.math.floor(7.44 * (-10)) / (-10)
  val n = 150
  val range = max - min
  val m = sturgesRule(n)
  val r = (scala.math.round(range * 10.0 / m) / 10.0)
  println(r)
  for(i <- 0 to m - 1) {
    println("" + (min + r * i) + " <= x < " + (min + r * (i + 1)))
    println(min + r * (i + 0.5))
  }
}

object Exercise2_5 extends App {
  val min = scala.math.floor(0.72 * 10) / 10
  val max = scala.math.floor(5.41 * (-10)) / (-10)
  val range = max - min
  val m = 10
  val r = (scala.math.round(range * 10.0 / m) / 10.0)
  for(i <- 0 to m - 1) {
    println("" + (min + r * i) + " <= x < " + (min + r * (i + 1)))
  }
}

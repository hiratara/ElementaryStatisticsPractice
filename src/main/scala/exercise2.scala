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

object Exercise2_6 extends App {
  val data = List[Double](
    1.845, 1.820, 1.863, 1.833, 1.835, 1.832,
    1.829, 1.837, 1.836, 1.830, 1.832, 1.837,
    1.843, 1.836, 1.842, 1.832, 1.835, 1.831,
    1.840, 1.835, 1.840, 1.836, 1.827, 1.846,
    1.840, 1.824, 1.828, 1.839, 1.834, 1.838,
    1.841, 1.833, 1.838, 1.834, 1.832, 1.835,
    1.838, 1.842, 1.825, 1.845, 1.836, 1.829,
    1.831, 1.836, 1.833, 1.848, 1.852, 1.834,
    1.826, 1.839, 1.834, 1.827, 1.836, 1.825,
    1.837, 1.835, 1.832, 1.848, 1.860, 1.850
  )

  drawFrequencyDistribution(10, data:_*)
}

object Exercise2_9 extends App {
  val data = List[Double](
    73, 65, 82, 70, 45, 50, 70, 54, 32, 75,
    75, 67, 65, 60, 75, 87, 83, 40, 72, 64,
    58, 75, 89, 70, 73, 55, 61, 68, 89, 93,
    43, 51, 59, 38, 65, 71, 75, 85, 65, 85,
    49, 97, 55, 60, 76, 75, 69, 35, 45, 63
  )
  drawCumulativeFrequencyDistribution(30, 100, 10, data:_*)
}

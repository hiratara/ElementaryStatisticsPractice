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

object Exercise2_10 extends App {
  val data = List[Double](
    13,  9,  5, 11, 14,  6,  5,  8, 11, 13,
    10, 16, 15,  3, 19, 18,  9,  9,  5, 12,
    13, 12, 15,  9, 18, 12, 16,  7, 12, 13,
    11, 18, 15,  9, 21,  9, 11,  6, 12, 12,
    10, 16,  2, 14, 10, 17,  8, 15, 11, 12
  )
  drawCumulativeFrequencyDistribution(2, 22, 3, data:_*)
}

object Exercise2_11 extends App {
  import scala.util.Random._
  def rollDice(): Int = nextInt(6) + 1

  val data: List[Double] = (0 to 99).map((_: Int) =>
    (if (rollDice() == 6) 1.0 else 0.0) + (if (rollDice() == 6) 1.0 else 0.0)
  ).toList
  drawFrequencyDistributionMinAndMax(0.0, 2.0, 1.0, data:_*)
}

object Exercise2_12 extends App {
  import scala.util.Random._
  def throw5(): List[Boolean] = (1 to 5).map(_ => nextBoolean()).toList
  def score(xs: List[Boolean]) = {
    def loop(t: Int, f: Int, xs: List[Boolean]): Int = {
      xs match {
        case Nil   => 0
        case x::xs => {
          val newT = if (x) t + 1 else t
          val newF = if (x) f else f + 1
          (if (newT > newF) 1 else 0) + loop(newT, newF, xs)
        }
      }
    }

    loop(0, 0, xs)
  }

  val data: List[Double] = (1 to 50).map(_ => score(throw5()): Double).toList
  drawFrequencyDistributionMinAndMax(0.0, 5.0, 1.0, data:_*)
}

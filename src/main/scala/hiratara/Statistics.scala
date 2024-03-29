package hiratara
import scala.math.BigInt

object Statistics {
  def arithmaticMean(xs: Double*): Double = xs.sum / xs.length
  def geometricMean(xs: Double*): Double = {
    Math.pow((xs foldLeft 1.0) {_ * _}, 1.0 / xs.length)
  }
  def harmonicMean(xs: Double*): Double =
    xs.length / (xs map { 1 / _ }).sum

  def variance(xs: Double*): Double = {
    val mean = arithmaticMean(xs:_*)
    arithmaticMean((xs map {_ - mean}) map { n => n * n }:_*)
  }

  def standardDeviation(xs: Double*): Double = Math sqrt variance(xs:_*)

  def quartile(xs: Double*):(Double, Double, Double) = {
    val q1Base = xs.length / 4 - 1
    val q2Base = xs.length / 2 - 1
    val q3Base = xs.length * 3 / 4 - 1
    val sorted = xs.sortWith(_ < _)

    (
      (sorted(q1Base) + sorted(q1Base + 1)) / 2,
      (sorted(q2Base) + sorted(q2Base + 1)) / 2,
      (sorted(q3Base) + sorted(q3Base + 1)) / 2
    )
  }

  def quartileDeviation(xs: Double*): Double = {
    val (q1, q2, q3) = quartile(xs:_*)
    (q3 - q1) / 2
  }

  def sturgesRule(n: Int): Int = {
    val result: Long = scala.math round (1.0 + 3.32 * (scala.math log10 n))
    result.toInt
  }

  def drawFrequencyDistribution(xs: Double*) {
    drawFrequencyDistribution(sturgesRule(xs.length), xs:_*)
  }

  def drawFrequencyDistribution(m: Int, xs: Double*) {
    val r: Double = (xs.max - xs.min) / m
    drawFrequencyDistributionMinAndMax(xs.min, xs.max, r, xs:_*)
  }

  def drawFrequencyDistributionMinAndMax(
    min: Double, max: Double, r: Double, xs: Double*
  ) {
    def nextRange(cur: Double, left: List[Double]): Unit = {
      val low  = left.filter(_ < cur)
      val high = left.filter(_ >= cur)
      println("*" * low.length) // from (cur - r) to cur
      if (max < cur) () else nextRange(cur + r, high)
    }

    nextRange(min + r, xs.toList)
  }

  def drawCumulativeFrequencyDistribution(
    min: Double, max: Double, r: Double, xs: Double*
  ) {
    def nextRange(cur: Double, left: List[Double]): Unit = {
      val low  = left.filter(_ < cur)
      val high = left.filter(_ >= cur)
      println("*" * low.length) // from (cur - r) to cur
      if (max < cur) () else nextRange(cur + r, left)
    }

    nextRange(min + r, xs.toList)
  }

  def meanFromFrequency(xs: (Double, Int)*) = {
    val total: Double = xs.map((x:(Double, Int)) => x._2).sum
    xs.map((x:(Double, Int)) => x._1 * x._2).sum / total
  }

  def varianceFromFrequency(xs: (Double, Int)*) = {
    val mean = meanFromFrequency(xs:_*)
    meanFromFrequency(xs.map((x:(Double, Int)) => {
      val delta = x._1 - mean
      (delta * delta, x._2)
    }):_*)
  }

  def standardDeviationFromFrequency(xs: (Double, Int)*) =
    scala.math sqrt varianceFromFrequency(xs:_*)

  def leastSquaresMethod(xys: (Double, Double)*) = {
    val n = xys.length
    val sumX = xys.map(_._1).sum
    val sumY = xys.map(_._2).sum
    val sumXX = xys.map {xy =>
      val x = xy._1
      x * x
    }.sum
    val sumYY = xys.map {xy =>
      val y = xy._2
      y * y
    }.sum
    val sumXY = xys.map {xy => xy._1 * xy._2}.sum
    val a = (sumXX * sumY - sumX * sumXY) / (n * sumXX - sumX * sumX)
    val b = (n * sumXY - sumX * sumY) / (n * sumXX - sumX * sumX)
    (a, b)
  }

  def sd_yx2(xys: (Double, Double)*) = {
    val n = xys.length
    val sumX = xys.map(_._1).sum
    val sumY = xys.map(_._2).sum
    val sumXX = xys.map {xy =>
      val x = xy._1
      x * x
    }.sum
    val sumYY = xys.map {xy =>
      val y = xy._2
      y * y
    }.sum
    val sumXY = xys.map {xy => xy._1 * xy._2}.sum

    val (a, b) = leastSquaresMethod(xys:_*)

    (sumYY - a * sumY - b * sumXY) / n
  }

  def factor(n: BigInt): BigInt = if (n <= 1) 1 else n * factor(n - 1)

  def combi(n: BigInt, m: BigInt): BigInt =
    factor(n) / factor(m) / factor(n - m)

  def binomialDistribution(n: Int, p: Double): (Int) => Double = {
    import scala.math.pow
    (x: Int) => combi(n, x).toDouble * pow(p, x) * pow(1 - p, n - x)
  }

  def poissonDistribution(m: Double): (Int) => Double = {
    import scala.math.pow
    (x: Int) => pow(m, x).toDouble / pow(2.71828, m).toDouble / factor(x).toDouble
  }

  def hypergeometricDistribution(
    n: Int, N: BigInt, Np: BigInt
  ): (Int) => Double = {
    (x: Int) =>
      (combi(Np, x) * combi(N - Np, n - x)).toDouble / combi(N, n).toDouble
  }

  def gaussianDistribution(μ: Double, σ2: Double): (Double) => Double = {
    import scala.math._
    def square(x: Double) = x * x

    (x: Double) => {
      val multiplier = - square(x - μ) / 2 / σ2
      exp(multiplier) / sqrt(2 * Pi * σ2)
    }
  }
}

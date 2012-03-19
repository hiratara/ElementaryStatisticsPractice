package hiratara

object Statistics {
  def arithmaticMean(xs: Double*): Double = xs.sum / xs.length
  def geometricMean(xs: Double*): Double = {
    Math.pow((xs foldLeft 1.0) {_ * _}, 1.0 / xs.length)
  }
  def harmonicMean(xs: Double*): Double =
    xs.length / (xs map { 1 / _ }).sum

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
}

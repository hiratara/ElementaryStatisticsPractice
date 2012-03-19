package hiratara

object Statistics {
  def arithmaticMean(xs: Double*): Double = xs.sum / xs.length
  def geometricMean(xs: Double*): Double = {
    Math.pow((xs foldLeft 1.0) {_ * _}, 1.0 / xs.length)
  }
  def harmonicMean(xs: Double*): Double =
    xs.length / (xs map { 1 / _ }).sum
}

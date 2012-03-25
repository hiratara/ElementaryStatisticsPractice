import hiratara.Statistics._

object Question3_1 extends App {
  val data: List[(Double, Double)] = List(
    (29, 238), (27, 220), (30, 255), (31, 268), (32, 275), (33, 263),
    (30, 240), (30, 235), (28, 230), (27, 212)
  )
  println(leastSquaresMethod(data:_*))
}

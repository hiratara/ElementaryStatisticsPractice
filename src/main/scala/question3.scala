import hiratara.Statistics._

object Question3_1 extends App {
  val data: List[(Double, Double)] = List(
    (29, 238), (27, 220), (30, 255), (31, 268), (32, 275), (33, 263),
    (30, 240), (30, 235), (28, 230), (27, 212)
  )
  println(leastSquaresMethod(data:_*))
}

  // /* heights and weights (p.66) */
  // val data: List[(Double, Double)] = List(
  //   (171, 62), (180, 71), (169, 53), (173, 78), (173, 59), (163, 54),
  //   (168, 62), (176, 60), (173, 62), (174, 60), (164, 50), (171, 66),
  //   (172, 69), (172, 63), (175, 62), (163, 65), (163, 53), (162, 52),
  //   (167, 60), (170, 67), (173, 70), (170, 67), (170, 56), (175, 68),
  //   (170, 56)
  // )

object Question3_2 extends App {
  val data: List[(Double, Double)] = List(
    (29, 238), (27, 220), (30, 255), (31, 268), (32, 275), (33, 263),
    (30, 240), (30, 235), (28, 230), (27, 212)
  )
  println(sd_yx2(data:_*))
}

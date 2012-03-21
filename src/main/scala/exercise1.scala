import hiratara.Statistics._

object Exercise1_2 extends App {
  println(geometricMean(4, 6, 9))
  println(harmonicMean(3, 4, 6))
}

object Exercise1_3 extends App {
  for ((l, m, n) <- List((10, 20, 30), (40, 100, 250))){
    println(arithmaticMean(l, m, n))
    println(geometricMean(l, m, n))
    println(harmonicMean(l, m, n))
  }
}

object Exercise1_4 extends App {
  val xs:List[Double] = List(
    78, 59, 54, 62, 60, 62, 60, 50, 66, 69, 63, 62, 65, 53, 52, 67, 70, 67, 
    56, 60, 56, 66, 55, 70
  );
  val (q1, q2, q3) = quartile(xs:_*)
  println(q1)
  println(q2)
  println(q3)
  println(quartileDeviation(xs:_*))
}

object Exercise1_10 extends App {
  val xs:List[Double] = List(
    1040, 1070, 1070, 860, 910, 1400, 1050, 890, 1100, 1090
  );
  println(arithmaticMean(xs:_*))
  println(variance(xs:_*))
  println(standardDeviation(xs:_*))
}

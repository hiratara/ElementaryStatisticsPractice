import hiratara.Statistics._

object Excersize1_2 extends App {
  println(geometricMean(4, 6, 9))
  println(harmonicMean(3, 4, 6))
}

object Excersize1_3 extends App {
  for ((l, m, n) <- List((10, 20, 30), (40, 100, 250))){
    println(arithmaticMean(l, m, n))
    println(geometricMean(l, m, n))
    println(harmonicMean(l, m, n))
  }
}

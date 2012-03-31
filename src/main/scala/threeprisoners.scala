import scala.util.Random._

object ThreePrisoners {
  val A = 0
  val B = 1
  val C = 2

  def playRole(keeperDecision: Array[Boolean] => Boolean): (Boolean, Boolean) = {
    val whoAlives = nextInt(3)
    val isDeath: Array[Boolean] = (0 to 2).map((x: Int) => x != whoAlives).toArray
    val hearBsDeath: Boolean = keeperDecision(isDeath)
    (hearBsDeath, isDeath(A))
  }

  def whichIsDeath(isDeath: Array[Boolean]) = {
    if (! isDeath(C)) true
    else if (! isDeath(B)) false
    else nextBoolean()
  }

  val leakRate: Double = 0.8
  def withNoAssumption(isDeath: Array[Boolean]) =
    if (isDeath(B) && nextDouble() < leakRate) true else false

  def statistics(keeperDecision: Array[Boolean] => Boolean): Double = {
    val results = (1 to 10000).map(_ => playRole(keeperDecision)).toList
    val resultsKnowOfB = results.filter(_._1)
    val numOfDead = resultsKnowOfB.count(_._2)
    numOfDead.toDouble / resultsKnowOfB.length.toDouble * 100
  }

  def main(args: Array[String]) {
    println("normal situation: %.2f %%" format statistics(withNoAssumption))
    println("ask which is death: %.2f %%" format statistics(whichIsDeath))
  }
}

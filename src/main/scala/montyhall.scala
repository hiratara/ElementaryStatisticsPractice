import scala.util.Random._

object MontyHall {
  def didWinGame(isChange: Boolean): Boolean = {
    val doors: Array[Boolean] = Array(false, false, false)
    doors(nextInt(3)) = true

    val playerChoice = nextInt(3)

    def tryChoosing(): Int = {
      val choice = nextInt(3)
      if (choice != playerChoice && ! doors(choice))
        choice
      else
        tryChoosing()
    }
    val montyChoice = tryChoosing()

    val finalAnswer =
      if (isChange) List(0, 1, 2).filter(
        (x: Int) => x != playerChoice && x != montyChoice
      )(0)
      else playerChoice

    return doors(finalAnswer)
  }

  def winningRate(doGame: () => Boolean) = {
    val total = 10000
    val winCount = (1 to total).map(_ => doGame()).count((x: Boolean) => x)

    winCount.toDouble / total.toDouble * 100
  }

  def main(args: Array[String]) {
    println("not change: %.2f %%".format(winningRate(() => didWinGame(false))))
    println("change: %.2f %%".format(winningRate(() => didWinGame(true))))
  }
}

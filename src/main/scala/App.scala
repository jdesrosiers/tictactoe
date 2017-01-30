import tictactoe._
import tictactoe.player._
import tictactoe.ui._

object App {
  def main(args: Array[String]): Unit = {
    val playerX = new ConsolePlayer()
    val playerO = new ConsolePlayer()

    if (args.contains("--game=4x4"))
      TicTacToeUI.fourByFour(TicTacToe.fourByFour, playerX, playerO).play()
    else
      TicTacToeUI.classic(TicTacToe.classic, playerX, playerO).play()
  }
}

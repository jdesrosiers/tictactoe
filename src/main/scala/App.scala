import tictactoe._
import tictactoe.ui._

object App {
  def main(args: Array[String]): Unit = {
    if (args.contains("--game=4x4"))
      TicTacToeUI.fourByFour(TicTacToe.fourByFour).play()
    else
      TicTacToeUI.classic(TicTacToe.classic).play()
  }
}

import tictactoe._
import tictactoe.ui._

object App {
  def main(args: Array[String]): Unit = {
    TicTacToeUI.classic(TicTacToe.classic).play()
  }
}

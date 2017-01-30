import scala.io.StdIn

import tictactoe._

object App {
  def main(args: Array[String]): Unit = {
    val board = Board()

    clearConsole
    println("Let's Play Tic Tac Toe!")

    println(render(board))

    print(s"It's ${render(board.player)}'s turn: ")
    StdIn.readLine
  }

  def clearConsole = print("\u001b[2J\u001b[0;0H")

  val render = Map(
    'X -> (Console.RED + "X" + Console.RESET)
  )

  def render(board: Board) = {
    """
     7 ║ 8 ║ 9
    ═══╬═══╬═══
     4 ║ 5 ║ 6
    ═══╬═══╬═══
     7 ║ 8 ║ 9
    """
  }
}

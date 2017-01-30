import scala.io.StdIn

import tictactoe._

object App {
  def main(args: Array[String]): Unit = {
    play()
  }

  val game = new TicTacToe()

  def play(board: Board = Board()): Unit = {
    clearConsole
    println("Let's Play Tic Tac Toe!")

    println(render(board))

    game.state(board) match {
      case 'xWins => println(s"${render('X)} wins!")
      case 'oWins => println(s"${render('O)} wins!")
      case 'draw => println("It's a draw")
      case 'inProgress =>
        print(s"It's ${render(board.player)}'s turn: ")
        val move = Symbol(s"_${StdIn.readLine}")

        if (game.canPlay(move, board))
          play(board.play(move))
        else
          play(board)
    }
  }

  def clearConsole = print("\u001b[2J\u001b[0;0H")

  val tokens = Map(
    'X -> (Console.RED + "X" + Console.RESET),
    'O -> (Console.BLUE + "O" + Console.RESET),
    '_1 -> "1", '_2 -> "2", '_3 -> "3",
    '_4 -> "4", '_5 -> "5", '_6 -> "6",
    '_7 -> "7", '_8 -> "8", '_9 -> "9"
  )

  def render(token: Symbol): String = tokens(token)

  def render(board: Board): String = {
    val replacements = for (position <- List('_7, '_8, '_9, '_4, '_5, '_6, '_1, '_2, '_3)) yield {
      board.at(position) match {
        case Some(player) => render(player)
        case None => render(position)
      }
    }

    """
     ? ║ ? ║ ?
    ═══╬═══╬═══
     ? ║ ? ║ ?
    ═══╬═══╬═══
     ? ║ ? ║ ?
    """.replace("?", "%s").format(replacements:_*)
  }
}

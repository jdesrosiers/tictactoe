package tictactoe.ui

import scala.io.StdIn
import tictactoe._
import tictactoe.ui.render._

class TicTacToeUI(game: TicTacToe, render: Render) {
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
}

object TicTacToeUI {
  def classic(game: TicTacToe) = new TicTacToeUI(game, new RenderClassic)
}

package tictactoeui

import tictactoe.{TicTacToe, Board}
import tictactoeui.Player
import tictactoeui.classic.RenderClassic
import tictactoeui.fourbyfour.RenderFourByFour

class TicTacToeUI(game: TicTacToe, playerX: Player, playerO: Player, render: Render) {
  val player = Map('X -> playerX, 'O -> playerO)

  def play(board: Board = Board()): Board = {
    clearConsole()
    println("Let's Play Tic Tac Toe!")

    println(render(board))

    game.state(board) match {
      case 'xWins => println(s"${render('X)} wins!"); board
      case 'oWins => println(s"${render('O)} wins!"); board
      case 'draw => println("It's a draw"); board
      case 'inProgress =>
        print(s"It's ${render(board.player)}'s turn: ")
        val move = player(board.player).getMove(board)

        if (game.canPlay(move, board))
          play(board.play(move))
        else
          play(board)
    }
  }

  def clearConsole(): Unit = print("\u001b[2J\u001b[0;0H")
}

object TicTacToeUI {
  def classic(game: TicTacToe, playerX: Player, playerO: Player) =
    new TicTacToeUI(game, playerX, playerO, new RenderClassic)

  def fourByFour(game: TicTacToe, playerX: Player, playerO: Player) =
    new TicTacToeUI(game, playerX, playerO, new RenderFourByFour)
}

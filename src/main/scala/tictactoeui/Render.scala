package tictactoeui

import tictactoe.Board

trait Render {
  def apply(token: Symbol): String
  def apply(board: Board): String
  def apply(page: Page): String =
s"""${clearConsole()}Let's Play Tic Tac Toe!
${apply(page.board)}
${page.state match {
  case 'xWins => s"${apply('X)} wins!\n"
  case 'oWins => s"${apply('O)} wins!\n"
  case 'draw => "It's a draw\n"
  case 'inProgress => s"It's ${apply(page.board.player)}'s turn: "
}}"""

  private def clearConsole(): String = "\u001b[2J\u001b[0;0H"
}

case class Page(state: Symbol, board: Board)

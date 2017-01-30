package tictactoe.ui.render

import tictactoe.Board

trait Render {
  def apply(token: Symbol): String
  def apply(board: Board): String
}

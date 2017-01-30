package tictactoe.player

import tictactoe.Board

trait Player {
  def getMove(board: Board): Symbol
}

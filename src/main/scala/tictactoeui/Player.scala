package tictactoeui

import tictactoe.Board

trait Player {
  def getMove(board: Board): Symbol
}

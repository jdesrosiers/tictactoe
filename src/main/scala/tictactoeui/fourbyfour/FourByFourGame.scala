package tictactoeui.fourbyfour

import tictactoe.{Board, TicTacToe}
import tictactoeui.Game

class FourByFourGame extends Game {
  private val game = TicTacToe.fourByFour

  def canPlay(position: Symbol, board: Board): Boolean = game.canPlay(position, board)
  def allowedMoves(board: Board): Set[Symbol] = game.allowedMoves(board)
  def state(board: Board): Symbol = game.state(board)
}


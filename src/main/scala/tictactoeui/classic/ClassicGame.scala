package tictactoeui.classic

import tictactoe.{Board, TicTacToe}
import tictactoeui.Game

class ClassicGame extends Game {
  private val game = TicTacToe.classic

  def canPlay(position: Symbol, board: Board): Boolean = game.canPlay(position, board)
  def allowedMoves(board: Board): Set[Symbol] = game.allowedMoves(board)
  def state(board: Board): Symbol = game.state(board)
}

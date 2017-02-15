package tictactoeui

import tictactoe.Board
import tictactoeui.classic.ClassicGame
import tictactoeui.fourbyfour.FourByFourGame

trait Game {
  def canPlay(position: Symbol, board: Board): Boolean
  def allowedMoves(board: Board): Set[Symbol]
  def state(board: Board): Symbol
}

object Game {
  val classic = new ClassicGame
  val fourByFour = new FourByFourGame
}

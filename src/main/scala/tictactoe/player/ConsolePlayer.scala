package tictactoe.player

import scala.io.StdIn
import tictactoe.Board

class ConsolePlayer() extends Player {
  def getMove(board: Board) = Symbol(s"_${StdIn.readLine}")
}

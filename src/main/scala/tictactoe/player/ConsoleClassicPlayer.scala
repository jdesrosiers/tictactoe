package tictactoe.player

import scala.io.StdIn
import tictactoe.Board

class ConsoleClassicPlayer() extends Player {
  val positions = Map(
    "7" -> 'topLeft, "8" -> 'topMiddle, "9" -> 'topRight,
    "4" -> 'middleLeft, "5" -> 'center, "6" -> 'middleRight,
    "1" -> 'bottomLeft, "2" -> 'bottomMiddle, "3" -> 'bottomRight
  )

  def getMove(board: Board) = positions.get(StdIn.readLine) match {
    case Some(position) => position
    case None => Symbol("")
  }
}

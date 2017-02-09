package tictactoe.player

import scala.io.StdIn
import tictactoe.Board

class ConsoleFourByFourPlayer() extends Player {
  val positions = Map(
    "1" -> 'A1, "2" -> 'A2, "3" -> 'A3, "4" -> 'A4,
    "5" -> 'B1, "6" -> 'B2, "7" -> 'B3, "8" -> 'B4,
    "9" -> 'C1, "a" -> 'C2, "b" -> 'C3, "c" -> 'C4,
    "d" -> 'D1, "e" -> 'D2, "f" -> 'D3, "g" -> 'D4
  )

  def getMove(board: Board) = positions.get(StdIn.readLine) match {
    case Some(position) => position
    case None => Symbol("")
  }
}

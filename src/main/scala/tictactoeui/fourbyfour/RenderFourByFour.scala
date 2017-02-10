package tictactoeui.fourbyfour

import tictactoe.Board
import tictactoeui.Render

class RenderFourByFour() extends Render {
  val tokens = Map(
    'X -> (Console.RED + "X" + Console.RESET),
    'O -> (Console.BLUE + "O" + Console.RESET),
    'A1 -> "1", 'A2 -> "2", 'A3 -> "3", 'A4 -> "4",
    'B1 -> "5", 'B2 -> "6", 'B3 -> "7", 'B4 -> "8",
    'C1 -> "9", 'C2 -> "a", 'C3 -> "b", 'C4 -> "c",
    'D1 -> "d", 'D2 -> "e", 'D3 -> "f", 'D4 -> "g"
  )

  def apply(token: Symbol): String = tokens(token)

  def apply(board: Board): String = {
    val replacements = for (position <- List('A1, 'A2, 'A3, 'A4, 'B1, 'B2, 'B3, 'B4, 'C1, 'C2, 'C3, 'C4, 'D1, 'D2, 'D3, 'D4)) yield {
      board.at(position) match {
        case Some(player) => apply(player)
        case None => apply(position)
      }
    }

    """
     ? ║ ? ║ ? ║ ?
    ═══╬═══╬═══╬═══
     ? ║ ? ║ ? ║ ?
    ═══╬═══╬═══╬═══
     ? ║ ? ║ ? ║ ?
    ═══╬═══╬═══╬═══
     ? ║ ? ║ ? ║ ?
    """.replace("?", "%s").format(replacements:_*)
  }
}


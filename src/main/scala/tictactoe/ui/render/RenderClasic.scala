package tictactoe.ui.render

import tictactoe.Board

class RenderClassic() extends Render {
  val tokens = Map(
    'X -> (Console.RED + "X" + Console.RESET),
    'O -> (Console.BLUE + "O" + Console.RESET),
    '_1 -> "1", '_2 -> "2", '_3 -> "3",
    '_4 -> "4", '_5 -> "5", '_6 -> "6",
    '_7 -> "7", '_8 -> "8", '_9 -> "9"
  )

  def apply(token: Symbol): String = tokens(token)

  def apply(board: Board): String = {
    val replacements = for (position <- List('_7, '_8, '_9, '_4, '_5, '_6, '_1, '_2, '_3)) yield {
      board.at(position) match {
        case Some(player) => apply(player)
        case None => apply(position)
      }
    }

    """
     ? ║ ? ║ ?
    ═══╬═══╬═══
     ? ║ ? ║ ?
    ═══╬═══╬═══
     ? ║ ? ║ ?
    """.replace("?", "%s").format(replacements:_*)
  }
}

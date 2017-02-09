package tictactoe.ui.render

import tictactoe.Board

class RenderClassic() extends Render {
  val tokens = Map(
    'X -> (Console.RED + "X" + Console.RESET),
    'O -> (Console.BLUE + "O" + Console.RESET),
    'topLeft -> "7", 'topMiddle -> "8", 'topRight -> "9",
    'middleLeft -> "4", 'center -> "5", 'middleRight -> "6",
    'bottomLeft -> "1", 'bottomMiddle -> "2", 'bottomRight -> "3"
  )

  def apply(token: Symbol): String = tokens(token)

  def apply(board: Board): String = {
    val positions = List(
      'topLeft, 'topMiddle, 'topRight,
      'middleLeft, 'center, 'middleRight,
      'bottomLeft, 'bottomMiddle, 'bottomRight
    )

    val replacements = for (position <- positions) yield {
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

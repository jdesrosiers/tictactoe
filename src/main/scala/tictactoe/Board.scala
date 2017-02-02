package tictactoe

/**
 * The Board represents the changeable state of a Tic Tac Toe game.  It should
 * be as small and efficient as possible.
 */
case class Board(player: Symbol = 'X, xs: Set[Symbol] = Set(), os: Set[Symbol] = Set()) {
  def play(position: Symbol): Board = player match {
    case 'X => Board('O, xs + position, os)
    case 'O => Board('X, xs, os + position)
  }

  def at(position: Symbol): Option[Symbol] =
    if (xs contains position) Some('X)
    else if (os contains position) Some('O)
    else None
}

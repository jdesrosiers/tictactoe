package tictactoe

/**
 * The Board represents the changeable state of a Tic Tac Toe game.  It should
 * be as small and efficient as possible.
 */
case class Board(player: Symbol = 'X, xs: Set[Symbol] = Set()) {
  def play(position: Symbol) = Board('O, xs + position)
  def at(position: Symbol) = if (xs contains position) Some('X) else None
}

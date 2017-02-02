package tictactoe

class TicTacToe(positions: Set[Symbol], winStates: List[Set[Symbol]]) {
  def canPlay(position: Symbol, board: Board): Boolean = (positions -- board.xs -- board.os) contains position
  def allowedMoves(board: Board): Set[Symbol] = positions.filter(canPlay(_, board))

  def state(board: Board): Symbol =
    if (winStates.exists(_ subsetOf board.xs)) 'xWins
    else if (winStates.exists(_ subsetOf board.os)) 'oWins
    else if (allowedMoves(board).isEmpty) 'draw
    else 'inProgress
}

object TicTacToe {
  val classic: TicTacToe = {
    val positions = Set('_1, '_2, '_3, '_4, '_5, '_6, '_7, '_8, '_9)
    val winStates = List(
      // rows
      Set('_7, '_8, '_9),
      Set('_4, '_5, '_6),
      Set('_1, '_2, '_3),

      // columns
      Set('_7, '_4, '_1),
      Set('_8, '_5, '_2),
      Set('_9, '_6, '_3),

      // diagonals
      Set('_7, '_5, '_3),
      Set('_9, '_5, '_1)
    )

    new TicTacToe(positions, winStates)
  }

  val fourByFour: TicTacToe = {
    val positions = Set('_1, '_2, '_3, '_4, '_5, '_6, '_7, '_8, '_9, '_a, '_b, '_c, '_d, '_e, '_f, '_g)
    val winStates = List(
      // rows
      Set('_1, '_2, '_3, '_4),
      Set('_5, '_6, '_7, '_8),
      Set('_9, '_a, '_b, '_c),
      Set('_d, '_e, '_f, '_g),

      // columns
      Set('_1, '_5, '_9, '_d),
      Set('_2, '_6, '_a, '_e),
      Set('_3, '_7, '_b, '_f),
      Set('_4, '_8, '_c, '_g),

      // diagonals
      Set('_1, '_6, '_b, '_g),
      Set('_4, '_7, '_a, '_d)
    )

    new TicTacToe(positions, winStates)
  }
}

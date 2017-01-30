package tictactoe

class TicTacToe(positions: Set[Symbol], winStates: List[Set[Symbol]]) {
  def canPlay(position: Symbol, board: Board) = (positions -- board.xs -- board.os) contains position
  def allowedMoves(board: Board) = positions.filter(canPlay(_, board))

  def state(board: Board) =
    if (winStates.exists(_ subsetOf board.xs)) 'xWins
    else if (winStates.exists(_ subsetOf board.os)) 'oWins
    else if (allowedMoves(board).isEmpty) 'draw
    else 'inProgress
}

object TicTacToe {
  def classic = {
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
}

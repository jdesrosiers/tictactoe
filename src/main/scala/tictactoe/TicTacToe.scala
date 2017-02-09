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
    val positions = Set(
      'topLeft, 'topMiddle, 'topRight,
      'middleLeft, 'center, 'middleRight,
      'bottomLeft, 'bottomMiddle, 'bottomRight
    )

    val winStates = List(
      // rows
      Set('topLeft, 'topMiddle, 'topRight),
      Set('middleLeft, 'center, 'middleRight),
      Set('bottomLeft, 'bottomMiddle, 'bottomRight),

      // columns
      Set('topLeft, 'middleLeft, 'bottomLeft),
      Set('topMiddle, 'center, 'bottomMiddle),
      Set('topRight, 'middleRight, 'bottomRight),

      // diagonals
      Set('topLeft, 'center, 'bottomRight),
      Set('topRight, 'center, 'bottomLeft)
    )

    new TicTacToe(positions, winStates)
  }

  val fourByFour: TicTacToe = {
    val positions = Set(
      'A1, 'A2, 'A3, 'A4,
      'B1, 'B2, 'B3, 'B4,
      'C1, 'C2, 'C3, 'C4,
      'D1, 'D2, 'D3, 'D4
    )

    val winStates = List(
      // rows
      Set('A1, 'A2, 'A3, 'A4),
      Set('B1, 'B2, 'B3, 'B4),
      Set('C1, 'C2, 'C3, 'C4),
      Set('D1, 'D2, 'D3, 'D4),

      // columns
      Set('A1, 'B1, 'C1, 'D1),
      Set('A2, 'B2, 'C2, 'D2),
      Set('A3, 'B3, 'C3, 'D3),
      Set('A4, 'B4, 'C4, 'D4),

      // diagonals
      Set('A1, 'B2, 'C3, 'D4),
      Set('A4, 'B3, 'C2, 'D1)
    )

    new TicTacToe(positions, winStates)
  }
}

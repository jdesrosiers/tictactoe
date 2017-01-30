package tictactoe

class TicTacToe() {
  val positions = Set('_1, '_2, '_3, '_4, '_5, '_6, '_7, '_8, '_9)
  def canPlay(position: Symbol, board: Board) = positions contains position
}

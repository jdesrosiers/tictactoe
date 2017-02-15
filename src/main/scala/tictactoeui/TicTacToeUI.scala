package tictactoeui

import eventdispatcher.EventDispatcher
import tictactoe.{TicTacToe, Board}
import scala.annotation.tailrec

class TicTacToeUI(game: TicTacToe, playerX: Player, playerO: Player, dispatcher: EventDispatcher[Page]) {
  val player = Map('X -> playerX, 'O -> playerO)

  @tailrec
  final def play(board: Board = Board()): Board = {
    val state = game.state(board)
    dispatcher.dispatch('play, Page(state, board))
    state match {
      case 'inProgress =>
        val move = player(board.player).getMove(board)
        val nextBoard = playTurn(move, board)
        play(nextBoard)
      case _ => board
    }
  }

  def playTurn(move: Symbol, board: Board): Board = {
    if (game.canPlay(move, board))
      board.play(move)
    else
      board
  }
}

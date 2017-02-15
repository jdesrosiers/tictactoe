package tictactoeui

import scala.util.Random
import tictactoe.Board

class MinimaxPlayer(game: Game, val depthLimit: Int) extends Player {
  case class Node(position: Symbol, score: Int)

  def getMove(board: Board): Symbol = minimax(board, depthLimit).position

  // alpha can't be Int.MinValue because Int.MinValue == -Int.MinValue
  private def minimax(board: Board, depth: Int, alpha: Int = -Int.MaxValue, beta: Int = Int.MaxValue): Node =
    game.state(board) match {
      case 'xWins => Node(null, isMaxPlayer(board) * 1)
      case 'oWins => Node(null, isMaxPlayer(board) * -1)
      case 'draw => Node(null, 0)
      case 'inProgress if depth <= 0 => Node(null, 0)
      case 'inProgress =>
        var a = alpha
        val children = for (position <- game.allowedMoves(board).toList if beta >= a) yield {
          val score = -minimax(board.play(position), depth - 1, -beta, -a).score
          a = Math.max(a, score)
          Node(position, score)
        }

        Random.shuffle(children).maxBy(_.score)
    }

  private def isMaxPlayer(board: Board) = board.player match {
    case 'X => 1
    case 'O => -1
  }
}

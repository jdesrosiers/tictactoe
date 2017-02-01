package tictactoe.player

import scala.util.Random
import tictactoe._

class MinimaxPlayer(game: TicTacToe, depthLimit: Int, isMaxPlayer: Boolean) extends Player {
  case class Node(position: Symbol, score: Int)

  def getMove(board: Board) = minimax(board, depthLimit, Int.MinValue, Int.MaxValue, isMaxPlayer).position

  private def minimax(board: Board, depth: Int, alpha: Int, beta: Int, isMaxPlayer: Boolean): Node =
    game.state(board) match {
      case 'xWins => Node(null, Int.MaxValue)
      case 'oWins => Node(null, Int.MinValue)
      case 'draw => Node(null, 0)
      case 'inProgress if depth <= 0 => Node(null, 0)
      case 'inProgress if isMaxPlayer =>
        var a = alpha
        val children = for (position <- game.allowedMoves(board).toList if beta >= a) yield {
          val node = Node(position, minimax(board.play(position), depth - 1, a, beta, !isMaxPlayer).score)
          a = Math.max(a, node.score)
          node
        }

        Random.shuffle(children).maxBy(_.score)
      case 'inProgress if !isMaxPlayer =>
        var b = beta
        val children = for (position <- game.allowedMoves(board).toList if b >= alpha) yield {
          val node = Node(position, minimax(board.play(position), depth - 1, alpha, b, !isMaxPlayer).score)
          b = Math.min(b, node.score)
          node
        }

        Random.shuffle(children).minBy(_.score)
    }
}

package tictactoe.player

import org.scalatest._
import tictactoe._

class MinimaxPlayerSpec extends FunSpec with Matchers {
  private def mkBoard(player: Symbol, str: String) = {
    val state = List('_7, '_8, '_9, '_4, '_5, '_6, '_1, '_2, '_3) zip str
    val xs = for ((position, player) <- state if player == 'X') yield position
    val os = for ((position, player) <- state if player == 'O') yield position
    Board(player, xs.toSet, os.toSet)
  }

  private val game = TicTacToe.classic

  describe("MinimaxPlayer at a leaf node") {
    it("should be null if X has won") {
      val player = new MinimaxPlayer(game, 0)
      val board = mkBoard('O, List(
        "OO-",
        "---",
        "XXX"
      ).mkString)
      player.getMove(board) should equal (null)
    }

    it("should be null if O has won") {
      val player = new MinimaxPlayer(game, 0)
      val board = mkBoard('X, List(
        "XX-",
        "-X-",
        "OOO"
      ).mkString)
      player.getMove(board) should equal (null)
    }

    it("should be null if it's a draw") {
      val player = new MinimaxPlayer(game, 0)
      val board = mkBoard('O, List(
        "XOO",
        "OXX",
        "XXO"
      ).mkString)
      player.getMove(board) should equal (null)
    }
  }

  describe("MinimaxPlayer one step from a solution") {
    it("should find a solution for X") {
      val player = new MinimaxPlayer(game, 1)
      val board = mkBoard('X, List(
        "OO-",
        "---",
        "XX-"
      ).mkString)
      player.getMove(board) should equal ('_3)
    }

    it("should find a solution for O") {
      val player = new MinimaxPlayer(game, 1)
      val board = mkBoard('O, List(
        "XX-",
        "X--",
        "OO-"
      ).mkString)
      player.getMove(board) should equal ('_3)
    }
  }

  describe("MinimaxPlayer where opponent can win in one move") {
    it("should block O from winning if it is playing X") {
      val player = new MinimaxPlayer(game, 2)
      val board = mkBoard('X, List(
        "O-O",
        "-X-",
        "X--"
      ).mkString)
      player.getMove(board) should equal ('_8)
    }

    it("should block X from winning if it is playing O") {
      val player = new MinimaxPlayer(game, 2)
      val board = mkBoard('O, List(
        "X-X",
        "-O-",
        "---"
      ).mkString)
      player.getMove(board) should equal ('_8)
    }
  }

  describe("Minimax with multiple options of the same value") {
    it("should choose a random position") {
      val player = new MinimaxPlayer(game, 2)
      val board = mkBoard('X, List(
        "-O-",
        "XOO",
        "XX-"
      ).mkString)
      Set('_3, '_7, '_9) contains player.getMove(board) should be (true)
    }
  }
}

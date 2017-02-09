package tictactoe.ui

import org.scalatest._

import tictactoe.{Board, TicTacToe}
import tictactoe.player.Player

class TicTacToeUISpec extends FunSpec with Matchers {
  val game = TicTacToe.classic

  describe("TicTacToe.play") {
    it("should run through a game where X wins") {
      val playerX = new StubPlayer(List('_1, '_2, '_3))
      val playerO = new StubPlayer(List('_7, '_8, '_9))
      val ui = TicTacToeUI.classic(game, playerX, playerO)

      Console.withOut(new java.io.ByteArrayOutputStream()) { // Suppress output
        game.state(ui.play()) should equal ('xWins)
      }
    }

    it("should run through a game where O wins") {
      val playerX = new StubPlayer(List('_1, '_2, '_4))
      val playerO = new StubPlayer(List('_7, '_8, '_9))
      val ui = TicTacToeUI.classic(game, playerX, playerO)

      Console.withOut(new java.io.ByteArrayOutputStream()) { // Suppress output
        game.state(ui.play()) should equal ('oWins)
      }
    }

    it("should run through a game that ends in a draw") {
      val playerX = new StubPlayer(List('_7, '_8, '_6, '_1, '_2))
      val playerO = new StubPlayer(List('_9, '_4, '_5, '_3))
      val ui = TicTacToeUI.classic(game, playerX, playerO)

      Console.withOut(new java.io.ByteArrayOutputStream()) { // Suppress output
        game.state(ui.play()) should equal ('draw)
      }
    }

    it("should not advance to the next player if an invalid position is played") {
      val playerX = new StubPlayer(List('_a, '_1, '_2, '_3))
      val playerO = new StubPlayer(List('_7, '_8, '_9))
      val ui = TicTacToeUI.classic(game, playerX, playerO)

      Console.withOut(new java.io.ByteArrayOutputStream()) { // Suppress output
        game.state(ui.play()) should equal ('xWins)
      }
    }

    it("should not advance to the next player if a position that has already been played is played") {
      val playerX = new StubPlayer(List('_1, '_7, '_2, '_3))
      val playerO = new StubPlayer(List('_7, '_8, '_9))
      val ui = TicTacToeUI.classic(game, playerX, playerO)

      Console.withOut(new java.io.ByteArrayOutputStream()) { // Suppress output
        game.state(ui.play()) should equal ('xWins)
      }
    }
  }
}

class StubPlayer(moves: List[Symbol]) extends Player {
  val moveIter = moves.iterator
  def getMove(board: Board): Symbol = moveIter.next
}

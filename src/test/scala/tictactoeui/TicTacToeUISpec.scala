package tictactoeui

import org.scalatest._

import tictactoe.{Board, TicTacToe}
import tictactoeui.Player

class TicTacToeUISpec extends FunSpec with Matchers {
  private val game = TicTacToe.classic

  describe("TicTacToe.play") {
    it("should run through a game where X wins") {
      val playerX = new StubPlayer(List('bottomLeft, 'bottomMiddle, 'bottomRight))
      val playerO = new StubPlayer(List('topLeft, 'topMiddle, 'topRight))
      val ui = TicTacToeUI.classic(game, playerX, playerO)

      Console.withOut(new java.io.ByteArrayOutputStream()) { // Suppress output
        game.state(ui.play()) should equal ('xWins)
      }
    }

    it("should run through a game where O wins") {
      val playerX = new StubPlayer(List('bottomLeft, 'bottomMiddle, 'middleLeft))
      val playerO = new StubPlayer(List('topLeft, 'topMiddle, 'topRight))
      val ui = TicTacToeUI.classic(game, playerX, playerO)

      Console.withOut(new java.io.ByteArrayOutputStream()) { // Suppress output
        game.state(ui.play()) should equal ('oWins)
      }
    }

    it("should run through a game that ends in a draw") {
      val playerX = new StubPlayer(List('topLeft, 'topMiddle, 'middleRight, 'bottomLeft, 'bottomMiddle))
      val playerO = new StubPlayer(List('topRight, 'middleLeft, 'center, 'bottomRight))
      val ui = TicTacToeUI.classic(game, playerX, playerO)

      Console.withOut(new java.io.ByteArrayOutputStream()) { // Suppress output
        game.state(ui.play()) should equal ('draw)
      }
    }

    it("should not advance to the next player if an invalid position is played") {
      val playerX = new StubPlayer(List('_a, 'bottomLeft, 'bottomMiddle, 'bottomRight))
      val playerO = new StubPlayer(List('topLeft, 'topMiddle, 'topRight))
      val ui = TicTacToeUI.classic(game, playerX, playerO)

      Console.withOut(new java.io.ByteArrayOutputStream()) { // Suppress output
        game.state(ui.play()) should equal ('xWins)
      }
    }

    it("should not advance to the next player if a position that has already been played is played") {
      val playerX = new StubPlayer(List('bottomLeft, 'topLeft, 'bottomMiddle, 'bottomRight))
      val playerO = new StubPlayer(List('topLeft, 'topMiddle, 'topRight))
      val ui = TicTacToeUI.classic(game, playerX, playerO)

      Console.withOut(new java.io.ByteArrayOutputStream()) { // Suppress output
        game.state(ui.play()) should equal ('xWins)
      }
    }
  }
}

class StubPlayer(moves: List[Symbol]) extends Player {
  private val moveIter = moves.iterator
  def getMove(board: Board): Symbol = moveIter.next
}
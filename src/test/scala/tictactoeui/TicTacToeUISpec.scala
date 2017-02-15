package tictactoeui

import org.scalatest._

import eventdispatcher.EventDispatcher
import tictactoe.{Board, TicTacToe}

class TicTacToeUISpec extends FunSpec with Matchers {
  describe("TicTacToeUI.play") {
    it("should loop until the game is finished") {
      val game = TicTacToe.classic
      val playerX = new StubPlayer(List('bottomLeft, 'bottomMiddle, 'bottomRight))
      val playerO = new StubPlayer(List('topLeft, 'topMiddle, 'topRight))
      val dispatcher = new EventDispatcher[Page]
      var playSpy = 0
      dispatcher.addListener('play) { _ => playSpy += 1 }
      val ui = new TicTacToeUI(game, playerX, playerO, dispatcher)

      game.state(ui.play()) should equal ('xWins)
      playSpy should equal (6)
    }
  }

  describe("TicTacToeUI.playTurn") {
    val ui = new TicTacToeUI(TicTacToe.classic, null, null, null)

    it("should return a board with a valid move applied") {
      val board = Board('X)
      ui.playTurn('topRight, board) should equal (Board('O, Set('topRight)))
    }

    it("should return an unmodified board if an invalid position is played") {
      val board = Board('X)
      ui.playTurn('invalidMove, board) should equal (board)
    }

    it("should return an unmodified board if a position that has already been played is played") {
      val board = Board('X, Set('topRight))
      ui.playTurn('topRight, board) should equal (board)
    }
  }
}

class StubPlayer(moves: List[Symbol]) extends Player {
  private val moveIter = moves.iterator
  def getMove(board: Board): Symbol = moveIter.next
}

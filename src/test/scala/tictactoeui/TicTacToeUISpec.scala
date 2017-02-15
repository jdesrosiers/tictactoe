package tictactoeui

import org.scalatest._

import eventdispatcher.EventDispatcher
import tictactoe.Board

class TicTacToeUISpec extends FunSpec with Matchers {
  describe("TicTacToeUI.play") {
    it("should loop until the game is finished") {
      val game = Game.classic
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
    it("should return a board with a valid move applied") {
      val ui = new TicTacToeUI(new StubCanPlayGame(true), null, null, null)
      val board = Board('X)
      ui.playTurn('topRight, board) should equal (Board('O, Set('topRight)))
    }

    it("should return an unmodified board if an invalid position is played") {
      val ui = new TicTacToeUI(new StubCanPlayGame(false), null, null, null)
      val board = Board('X)
      ui.playTurn('invalidMove, board) should equal (board)
    }

    it("should return an unmodified board if a position that has already been played is played") {
      val ui = new TicTacToeUI(new StubCanPlayGame(false), null, null, null)
      val board = Board('X, Set('topRight))
      ui.playTurn('topRight, board) should equal (board)
    }
  }
}

class StubPlayer(moves: List[Symbol]) extends Player {
  private val moveIter = moves.iterator
  def getMove(board: Board): Symbol = moveIter.next
}

class StubCanPlayGame(canPlay: Boolean) extends Game {
  def canPlay(position: Symbol, board: Board): Boolean = canPlay
  def allowedMoves(board: Board): Set[Symbol] = ???
  def state(board: Board): Symbol = ???
}

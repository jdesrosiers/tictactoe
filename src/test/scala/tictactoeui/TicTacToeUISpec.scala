package tictactoeui

import org.scalatest._

import tictactoe.{Board, TicTacToe}

class TicTacToeUISpec extends FunSpec with Matchers {
  describe("TicTacToeUI.play") {
    it("should loop until the game is finished") {
      val game = TicTacToe.classic
      val playerX = new StubPlayer(List('bottomLeft, 'bottomMiddle, 'bottomRight))
      val playerO = new StubPlayer(List('topLeft, 'topMiddle, 'topRight))
      val render = new StubRender
      val ui = new TicTacToeUI(game, playerX, playerO, render)

      game.state(ui.play()) should equal ('xWins)
      render.renderPageSpy should equal (6)
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

class StubRender extends Render {
  var renderPageSpy = 0

  def apply(token: Symbol): String = ???
  def apply(board: Board): String = ???
  override def apply(page: Page): String = {
    renderPageSpy += 1
    ""
  }
}

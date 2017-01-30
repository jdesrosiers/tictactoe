package tictactoe

import org.scalatest._

class TicTacToeSpec extends FunSpec with Matchers {
  val game = new TicTacToe()

  describe("A Tic Tac Toe player") {
    it("should be able to play positions 1-9") {
      val expected = List('_1, '_2, '_3, '_4, '_5, '_6, '_7, '_8, '_9)
      game.allowedMoves(Board()) should contain theSameElementsAs expected
    }

    it("should not be allowed to play a position that has already been played by X") {
      game.canPlay('_1, Board('O, Set('_1), Set())) should be (false)
    }

    it("should not be allowed to play a position that has already been played by O") {
      game.canPlay('_1, Board('X, Set(), Set('_1))) should be (false)
    }
  }

  describe("The game status") {
    // xWins
    it("should be xWins if X has the top row") {
      game.state(Board('X, Set('_7, '_8, '_9), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the middle row") {
      game.state(Board('X, Set('_4, '_5, '_6), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the bottom row") {
      game.state(Board('X, Set('_1, '_2, '_3), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the left column") {
      game.state(Board('X, Set('_7, '_4, '_1), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the middle column") {
      game.state(Board('X, Set('_8, '_5, '_2), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the right column") {
      game.state(Board('X, Set('_9, '_6, '_3), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the backward diagonal") {
      game.state(Board('X, Set('_9, '_5, '_1), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the forward diagonal") {
      game.state(Board('X, Set('_7, '_5, '_3, '_1), Set())) should equal ('xWins)
    }

    // oWins
    it("should be oWins if O has the top row") {
      game.state(Board('X, Set(), Set('_7, '_8, '_9))) should equal ('oWins)
    }

    it("should be oWins if O has the middle row") {
      game.state(Board('X, Set(), Set('_4, '_5, '_6))) should equal ('oWins)
    }

    it("should be oWins if O has the bottom row") {
      game.state(Board('X, Set(), Set('_1, '_2, '_3))) should equal ('oWins)
    }

    it("should be oWins if O has the left column") {
      game.state(Board('X, Set(), Set('_7, '_4, '_1))) should equal ('oWins)
    }

    it("should be oWins if O has the middle column") {
      game.state(Board('X, Set(), Set('_8, '_5, '_2))) should equal ('oWins)
    }

    it("should be oWins if O has the right column") {
      game.state(Board('X, Set(), Set('_9, '_6, '_3))) should equal ('oWins)
    }

    it("should be oWins if O has the backward diagonal") {
      game.state(Board('X, Set(), Set('_9, '_5, '_1))) should equal ('oWins)
    }

    it("should be oWins if O has the forward diagonal") {
      game.state(Board('X, Set(), Set('_7, '_5, '_3))) should equal ('oWins)
    }

    // draw
    it("should be draw if there are no more moves left and there are no winners") {
      val board = Board('O, Set('_1, '_2, '_5, '_6, '_7), Set('_3, '_4, '_8, '_9))
      game.state(board) should equal ('draw)
    }

    // inProgress
    it("should be inProgress if it is not in an end-game state") {
      game.state(Board()) should equal ('inProgress)
    }
  }
}

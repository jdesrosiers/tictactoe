package tictactoe

import org.scalatest._

class TicTacToeClassicSpec extends FunSpec with Matchers {
  private val game = TicTacToe.classic

  describe("A Tic Tac Toe player") {
    it("should be able to play positions all positions") {
      val expected = Set(
        'topLeft, 'topMiddle, 'topRight,
        'middleLeft, 'center, 'middleRight,
        'bottomLeft, 'bottomMiddle, 'bottomRight
      )
      game.allowedMoves(Board()) should equal (expected)
    }
  }

  describe("The game status") {
    // xWins
    it("should be xWins if X has the top row") {
      game.state(Board('X, Set('topLeft, 'topMiddle, 'topRight), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the middle row") {
      game.state(Board('X, Set('middleLeft, 'center, 'middleRight), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the bottom row") {
      game.state(Board('X, Set('bottomLeft, 'bottomMiddle, 'bottomRight), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the left column") {
      game.state(Board('X, Set('topLeft, 'topMiddle, 'topRight), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the middle column") {
      game.state(Board('X, Set('topMiddle, 'center, 'bottomMiddle), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the right column") {
      game.state(Board('X, Set('topRight, 'middleRight, 'bottomRight), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the backward diagonal") {
      game.state(Board('X, Set('topRight, 'center, 'bottomLeft), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the forward diagonal") {
      game.state(Board('X, Set('topLeft, 'center, 'bottomRight), Set())) should equal ('xWins)
    }

    // oWins
    it("should be oWins if O has the top row") {
      game.state(Board('X, Set(), Set('topLeft, 'topMiddle, 'topRight))) should equal ('oWins)
    }

    it("should be oWins if O has the middle row") {
      game.state(Board('X, Set(), Set('middleLeft, 'center, 'middleRight))) should equal ('oWins)
    }

    it("should be oWins if O has the bottom row") {
      game.state(Board('X, Set(), Set('bottomLeft, 'bottomMiddle, 'bottomRight))) should equal ('oWins)
    }

    it("should be oWins if O has the left column") {
      game.state(Board('X, Set(), Set('topLeft, 'middleLeft, 'bottomLeft))) should equal ('oWins)
    }

    it("should be oWins if O has the middle column") {
      game.state(Board('X, Set(), Set('topMiddle, 'center, 'bottomMiddle))) should equal ('oWins)
    }

    it("should be oWins if O has the right column") {
      game.state(Board('X, Set(), Set('topRight, 'middleRight, 'bottomRight))) should equal ('oWins)
    }

    it("should be oWins if O has the backward diagonal") {
      game.state(Board('X, Set(), Set('topRight, 'center, 'bottomLeft))) should equal ('oWins)
    }

    it("should be oWins if O has the forward diagonal") {
      game.state(Board('X, Set(), Set('topLeft, 'center, 'bottomRight))) should equal ('oWins)
    }

    // draw
    it("should be draw if there are no more moves left and there are no winners") {
      val board = Board('O, Set('bottomLeft, 'bottomMiddle, 'center, 'middleRight, 'topLeft), Set('bottomRight, 'middleLeft, 'topMiddle, 'topRight))
      game.state(board) should equal ('draw)
    }

    // inProgress
    it("should be inProgress if it is not in an end-game state") {
      game.state(Board()) should equal ('inProgress)
    }
  }
}

package tictactoe

import org.scalatest._

class TicTacToeFourByFourSpec extends FunSpec with Matchers {
  val game = TicTacToe.fourByFour

  describe("A Tic Tac Toe player") {
    it("should be able to play positions 1-g") {
      val expected = List('_1, '_2, '_3, '_4, '_5, '_6, '_7, '_8, '_9, '_a, '_b, '_c, '_d, '_e, '_f, '_g)
      game.allowedMoves(Board()) should contain theSameElementsAs expected
    }
  }

  describe("The game status") {
    // xWins
    it("should be xWins if X has the first row") {
      game.state(Board('X, Set('_1, '_2, '_3, '_4), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the second row") {
      game.state(Board('X, Set('_5, '_6, '_7, '_8), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the third row") {
      game.state(Board('X, Set('_9, '_a, '_b, '_c), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the fourth row") {
      game.state(Board('X, Set('_d, '_e, '_f, '_g), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the first column") {
      game.state(Board('X, Set('_1, '_5, '_9, '_d), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the second column") {
      game.state(Board('X, Set('_2, '_6, '_a, '_e), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the third column") {
      game.state(Board('X, Set('_3, '_7, '_b, '_f), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the fourth column") {
      game.state(Board('X, Set('_4, '_8, '_c, '_g), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the forward diagonal") {
      game.state(Board('X, Set('_1, '_6, '_b, '_g), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the backward diagonal") {
      game.state(Board('X, Set('_4, '_7, '_a, '_d), Set())) should equal ('xWins)
    }

    // oWins
    it("should be oWins if O has the first row") {
      game.state(Board('X, Set(), Set('_1, '_2, '_3, '_4))) should equal ('oWins)
    }

    it("should be oWins if O has the second row") {
      game.state(Board('X, Set(), Set('_5, '_6, '_7, '_8))) should equal ('oWins)
    }

    it("should be oWins if O has the third row") {
      game.state(Board('X, Set(), Set('_9, '_a, '_b, '_c))) should equal ('oWins)
    }

    it("should be oWins if O has the fourth row") {
      game.state(Board('X, Set(), Set('_d, '_e, '_f, '_g))) should equal ('oWins)
    }

    it("should be oWins if O has the first column") {
      game.state(Board('X, Set(), Set('_1, '_5, '_9, '_d))) should equal ('oWins)
    }

    it("should be oWins if O has the second column") {
      game.state(Board('X, Set(), Set('_2, '_6, '_a, '_e))) should equal ('oWins)
    }

    it("should be oWins if O has the third column") {
      game.state(Board('X, Set(), Set('_3, '_7, '_b, '_f))) should equal ('oWins)
    }

    it("should be oWins if O has the fourth column") {
      game.state(Board('X, Set(), Set('_4, '_8, '_c, '_g))) should equal ('oWins)
    }

    it("should be oWins if O has the forward diagonal") {
      game.state(Board('X, Set(), Set('_1, '_6, '_b, '_g))) should equal ('oWins)
    }

    it("should be oWins if O has the backward diagonal") {
      game.state(Board('X, Set(), Set('_4, '_7, '_a, '_d))) should equal ('oWins)
    }

    // draw
    it("should be draw if there are no more moves left and there are no winners") {
      val board = Board('O, Set('_1, '_2, '_5, '_6, '_7, '_a, '_b, '_c, '_f), Set('_3, '_4, '_8, '_9, '_d, '_e, '_g))
      game.state(board) should equal ('draw)
    }

    // inProgress
    it("should be inProgress if it is not in an end-game state") {
      game.state(Board()) should equal ('inProgress)
    }
  }
}

package tictactoe

import org.scalatest._

class TicTacToeFourByFourSpec extends FunSpec with Matchers {
  private val game = TicTacToe.fourByFour

  describe("A Tic Tac Toe player") {
    it("should be able to play positions 1-g") {
      val expected = List('A1, 'A2, 'A3, 'A4, 'B1, 'B2, 'B3, 'B4, 'C1, 'C2, 'C3, 'C4, 'D1, 'D2, 'D3, 'D4)
      game.allowedMoves(Board()) should contain theSameElementsAs expected
    }
  }

  describe("The game status") {
    // xWins
    it("should be xWins if X has the first row") {
      game.state(Board('X, Set('A1, 'A2, 'A3, 'A4), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the second row") {
      game.state(Board('X, Set('B1, 'B2, 'B3, 'B4), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the third row") {
      game.state(Board('X, Set('C1, 'C2, 'C3, 'C4), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the fourth row") {
      game.state(Board('X, Set('D1, 'D2, 'D3, 'D4), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the first column") {
      game.state(Board('X, Set('A1, 'B1, 'C1, 'D1), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the second column") {
      game.state(Board('X, Set('A2, 'B2, 'C2, 'D2), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the third column") {
      game.state(Board('X, Set('A3, 'B3, 'C3, 'D3), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the fourth column") {
      game.state(Board('X, Set('A4, 'B4, 'C4, 'D4), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the forward diagonal") {
      game.state(Board('X, Set('A1, 'B2, 'C3, 'D4), Set())) should equal ('xWins)
    }

    it("should be xWins if X has the backward diagonal") {
      game.state(Board('X, Set('A4, 'B3, 'C2, 'D1), Set())) should equal ('xWins)
    }

    // oWins
    it("should be oWins if O has the first row") {
      game.state(Board('X, Set(), Set('A1, 'A2, 'A3, 'A4))) should equal ('oWins)
    }

    it("should be oWins if O has the second row") {
      game.state(Board('X, Set(), Set('B1, 'B2, 'B3, 'B4))) should equal ('oWins)
    }

    it("should be oWins if O has the third row") {
      game.state(Board('X, Set(), Set('C1, 'C2, 'C3, 'C4))) should equal ('oWins)
    }

    it("should be oWins if O has the fourth row") {
      game.state(Board('X, Set(), Set('D1, 'D2, 'D3, 'D4))) should equal ('oWins)
    }

    it("should be oWins if O has the first column") {
      game.state(Board('X, Set(), Set('A1, 'B1, 'C1, 'D1))) should equal ('oWins)
    }

    it("should be oWins if O has the second column") {
      game.state(Board('X, Set(), Set('A2, 'B2, 'C2, 'D2))) should equal ('oWins)
    }

    it("should be oWins if O has the third column") {
      game.state(Board('X, Set(), Set('A3, 'B3, 'C3, 'D3))) should equal ('oWins)
    }

    it("should be oWins if O has the fourth column") {
      game.state(Board('X, Set(), Set('A4, 'B4, 'C4, 'D4))) should equal ('oWins)
    }

    it("should be oWins if O has the forward diagonal") {
      game.state(Board('X, Set(), Set('A1, 'B2, 'C3, 'D4))) should equal ('oWins)
    }

    it("should be oWins if O has the backward diagonal") {
      game.state(Board('X, Set(), Set('A4, 'B3, 'C2, 'D1))) should equal ('oWins)
    }

    // draw
    it("should be draw if there are no more moves left and there are no winners") {
      val board = Board('O, Set('A1, 'A2, 'B1, 'B2, 'B3, 'C2, 'C3, 'C4, 'D3), Set('A3, 'A4, 'B4, 'C1, 'D1, 'D2, 'D4))
      game.state(board) should equal ('draw)
    }

    // inProgress
    it("should be inProgress if it is not in an end-game state") {
      game.state(Board()) should equal ('inProgress)
    }
  }
}

package tictactoe

import org.scalatest._

class TicTacToeSpec extends FunSpec with Matchers {
  describe("A Tic Tac Toe player") {
    val game = new TicTacToe(Set('a, 'b, 'c, 'd), List())

    it("should be able to play all positions on an empty board") {
      game.allowedMoves(Board()) should contain theSameElementsAs List('a, 'b, 'c, 'd)
    }

    it("should not be allowed to play a position that has already been played by X") {
      game.canPlay('a, Board('O, Set('a), Set())) should be (false)
      game.canPlay('a, Board('X, Set('a), Set())) should be (false)
    }

    it("should not be allowed to play a position that has already been played by O") {
      game.canPlay('a, Board('X, Set(), Set('a))) should be (false)
      game.canPlay('a, Board('O, Set(), Set('a))) should be (false)
    }
  }

  describe("The game status") {
    val game = new TicTacToe(Set('a, 'b, 'c, 'd), List(Set('a, 'b), Set('c, 'd)))

    // xWins
    it("should be xWins if X has board positions that include a win state") {
      game.state(Board('O, Set('a, 'b, 'd), Set('c))) should equal ('xWins)
    }

    // oWins
    it("should be oWins if O has board positions that include a win state") {
      game.state(Board('X, Set('c), Set('a, 'b, 'd))) should equal ('oWins)
    }

    // draw
    it("should be draw if there are no more moves left and there are no winners") {
      val board = Board('X, Set('a, 'c), Set('b, 'd))
      game.state(board) should equal ('draw)
    }

    // inProgress
    it("should be inProgress if it is not in an end-game state") {
      game.state(Board()) should equal ('inProgress)
    }
  }
}

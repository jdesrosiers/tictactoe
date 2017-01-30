package tictactoe

import org.scalatest._

class TicTacToeSpec extends FunSpec with Matchers {
  describe("A Tic Tac Toe player") {
    val game = new TicTacToe()

    it("should be able to play positions 1-9") {
      val expected = List('_1, '_2, '_3, '_4, '_5, '_6, '_7, '_8, '_9)
      game.allowedMoves(Board()) should contain theSameElementsAs expected
    }

    it("should not be allowed to play a position that has already been played") {
      game.canPlay('_1, Board('O, Set('_1), Set())) should be (false)
      game.canPlay('_1, Board('X, Set(), Set('_1))) should be (false)
    }
  }
}

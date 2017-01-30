package tictactoe

import org.scalatest._

class TicTacToeSpec extends FunSpec with Matchers {
  describe("A Tic Tac Toe player") {
    val game = new TicTacToe()

    it("should be allowed to play position 1") { game.canPlay('_1, Board()) should be (true) }
    it("should be allowed to play position 2") { game.canPlay('_2, Board()) should be (true) }
    it("should be allowed to play position 3") { game.canPlay('_3, Board()) should be (true) }
    it("should be allowed to play position 4") { game.canPlay('_4, Board()) should be (true) }
    it("should be allowed to play position 5") { game.canPlay('_5, Board()) should be (true) }
    it("should be allowed to play position 6") { game.canPlay('_6, Board()) should be (true) }
    it("should be allowed to play position 7") { game.canPlay('_7, Board()) should be (true) }
    it("should be allowed to play position 8") { game.canPlay('_8, Board()) should be (true) }
    it("should be allowed to play position 9") { game.canPlay('_9, Board()) should be (true) }
  }
}

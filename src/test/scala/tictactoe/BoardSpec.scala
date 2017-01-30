package tictactoe

import org.scalatest._

class BoardSpec extends FunSpec with Matchers {
  describe("A Board") {
    it("should default to X as the first player") {
      Board().player should equal ('X)
    }

    it("can be initialized to any player") {
      Board('O).player should equal('O)
      Board('X).player should equal('X)
    }
  }

  describe("X Playing position 1") {
    val board = Board('X).play('_1)

    it("should result in a Board with 1 belonging to X") { board.at('_1) should equal (Some('X)) }
    it("should result in a Board where the player is O") { board.player should equal ('O) }
  }

  describe("O Playing position 1") {
    val board = Board('O).play('_1)

    it("should result in a Board with 1 belonging to O") { board.at('_1) should equal (Some('O)) }
    it("should result in a Board where the player is X") { board.player should equal ('X) }
  }
}

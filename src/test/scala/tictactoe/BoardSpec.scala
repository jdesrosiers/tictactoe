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
}

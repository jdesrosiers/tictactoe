package tictactoeui

import org.scalatest._

import tictactoeui.classic.ConsoleClassicPlayer

class TicTacToeUIFactorySpec extends FunSpec with Matchers {
  describe("buildPlayer") {
    val config = Map[Symbol, String]('defaultMinimaxDepth -> "6")
    val factory = new TicTacToeUIFactory(GameVariation.classic, config)

    it("should return the game variation's `humanPlayer` value for a human player") {
      factory.buildPlayer("human", null) shouldBe a [ConsoleClassicPlayer]
    }

    it("should return a MinimaxPlayer for a minimax player with default depth") {
      val player = factory.buildPlayer("minimax", null)
      player shouldBe a [MinimaxPlayer]
      player.asInstanceOf[MinimaxPlayer].depthLimit should equal(6)
    }

    it("should return a MinimaxPlayer for a minimax,3 player with depth 3") {
      val player = factory.buildPlayer("minimax,3", null)
      player shouldBe a [MinimaxPlayer]
      player.asInstanceOf[MinimaxPlayer].depthLimit should equal(3)
    }
  }
}

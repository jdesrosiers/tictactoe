package tictactoe.player

import org.scalatest._

import java.io.StringReader
import tictactoe.Board

class ConsoleClassicPlayerSpec extends FunSpec with Matchers {
  val player = new ConsoleClassicPlayer()

  describe("getMove") {
    it("should map 7 to topLeft") {
      withInput("7") { player.getMove(Board()) should equal ('topLeft) }
    }
    it("should map 8 to topMiddle") {
      withInput("8") { player.getMove(Board()) should equal ('topMiddle) }
    }
    it("should map 9 to topRight") {
      withInput("9") { player.getMove(Board()) should equal ('topRight) }
    }

    it("should map 4 to middleLeft") {
      withInput("4") { player.getMove(Board()) should equal ('middleLeft) }
    }
    it("should map 5 to center") {
      withInput("5") { player.getMove(Board()) should equal ('center) }
    }
    it("should map 6 to middleRight") {
      withInput("6") { player.getMove(Board()) should equal ('middleRight) }
    }

    it("should map 1 to bottomLeft") {
      withInput("1") { player.getMove(Board()) should equal ('bottomLeft) }
    }
    it("should map 2 to bottomMiddle") {
      withInput("2") { player.getMove(Board()) should equal ('bottomMiddle) }
    }
    it("should map 3 to bottomRight") {
      withInput("3") { player.getMove(Board()) should equal ('bottomRight) }
    }
  }

  def withInput[T](input: String)(thunk: => T) = Console.withIn(new StringReader(input)) { thunk }
}

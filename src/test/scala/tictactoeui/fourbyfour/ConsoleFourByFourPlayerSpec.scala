package tictactoeui.fourbyfour

import org.scalatest._

import java.io.StringReader
import tictactoe.Board

class ConsoleFourByFourPlayerSpec extends FunSpec with Matchers {
  val player = new ConsoleFourByFourPlayer()

  describe("getMove") {
    it("should map 1 to A1") {
      withInput("1") { player.getMove(Board()) should equal ('A1) }
    }
    it("should map 2 to A2") {
      withInput("2") { player.getMove(Board()) should equal ('A2) }
    }
    it("should map 3 to A3") {
      withInput("3") { player.getMove(Board()) should equal ('A3) }
    }
    it("should map 4 to A4") {
      withInput("4") { player.getMove(Board()) should equal ('A4) }
    }

    it("should map 5 to B1") {
      withInput("5") { player.getMove(Board()) should equal ('B1) }
    }
    it("should map 6 to B2") {
      withInput("6") { player.getMove(Board()) should equal ('B2) }
    }
    it("should map 7 to B3") {
      withInput("7") { player.getMove(Board()) should equal ('B3) }
    }
    it("should map 8 to B4") {
      withInput("8") { player.getMove(Board()) should equal ('B4) }
    }

    it("should map 9 to C1") {
      withInput("9") { player.getMove(Board()) should equal ('C1) }
    }
    it("should map a to C2") {
      withInput("a") { player.getMove(Board()) should equal ('C2) }
    }
    it("should map b to C3") {
      withInput("b") { player.getMove(Board()) should equal ('C3) }
    }
    it("should map c to C4") {
      withInput("c") { player.getMove(Board()) should equal ('C4) }
    }

    it("should map d to D1") {
      withInput("d") { player.getMove(Board()) should equal ('D1) }
    }
    it("should map e to D2") {
      withInput("e") { player.getMove(Board()) should equal ('D2) }
    }
    it("should map f to D3") {
      withInput("f") { player.getMove(Board()) should equal ('D3) }
    }
    it("should map g to D4") {
      withInput("g") { player.getMove(Board()) should equal ('D4) }
    }
  }

  private def withInput[T](input: String)(thunk: => T) = Console.withIn(new StringReader(input)) { thunk }
}

package tictactoeui

import org.scalatest._

import tictactoe.Board

// Note: Uses the self shunting pattern to test the Render trait
class RenderSpec extends FunSpec with Matchers with Render {
  def tokens = Map('X -> "X", 'O -> "O")
  def apply(token: Symbol): String = tokens(token)

  val boardStr = "***board***"
  def apply(board: Board): String = boardStr

  describe("Rendering an X wins page") {
    val page = Page('xWins, Board())
    it("should include 'X wins!'") { apply(page) should include ("X wins!") }
    it("should include the board") { apply(page) should include (boardStr) }
  }

  describe("Rendering an O wins page") {
    val page = Page('oWins, Board())
    it("should include 'O wins!'") { apply(page) should include ("O wins!") }
    it("should include the board") { apply(page) should include (boardStr) }
  }

  describe("Rendering a draw page") {
    val page = Page('draw, Board())
    it("should include 'It's a draw'") { apply(page) should include ("It's a draw") }
    it("should include the board") { apply(page) should include (boardStr) }
  }

  describe("Rendering an X's turn page") {
    val page = Page('inProgress, Board('X))
    it("should include 'It's X's turn'") { apply(page) should include ("It's X's turn") }
    it("should include the board") { apply(page) should include (boardStr) }
  }

  describe("Rendering an O's turn page") {
    val page = Page('inProgress, Board('O))
    it("should include 'It's O's turn'") { apply(page) should include ("It's O's turn") }
    it("should include the board") { apply(page) should include (boardStr) }
  }
}

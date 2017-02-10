package tictactoeui.fourbyfour

import org.scalatest._
import tictactoe.Board

class RenderFourByFourSpec extends FunSpec with Matchers {
  val render = new RenderFourByFour()

  describe("Player X") {
    it("should be represented by a red X") {
      render('X) should equal (Console.RED + "X" + Console.RESET)
    }
  }

  describe("Player O") {
    it("should be represented by a blue O") {
      render('O) should equal (Console.BLUE + "O" + Console.RESET)
    }
  }

  describe("Board positions") {
    it("should render a numeric position based on the position given") {
      render('A1) should equal ("1")
      render('A2) should equal ("2")
      render('A3) should equal ("3")
      render('A4) should equal ("4")
      render('B1) should equal ("5")
      render('B2) should equal ("6")
      render('B3) should equal ("7")
      render('B4) should equal ("8")
      render('C1) should equal ("9")
      render('C2) should equal ("a")
      render('C3) should equal ("b")
      render('C4) should equal ("c")
      render('D1) should equal ("d")
      render('D2) should equal ("e")
      render('D3) should equal ("f")
      render('D4) should equal ("g")
    }
  }

  describe("A Tic Tac Toe board") {
    it("should show board positions for available moves") {
      val expected = """
     1 ║ 2 ║ 3 ║ 4
    ═══╬═══╬═══╬═══
     5 ║ 6 ║ 7 ║ 8
    ═══╬═══╬═══╬═══
     9 ║ a ║ b ║ c
    ═══╬═══╬═══╬═══
     d ║ e ║ f ║ g
    """
      render(Board()) should equal (expected)
    }

    it("should display an X on board positions played by the first player") {
      val x = " " + render('X)
      val expected = s"""
     1 ║ 2 ║ 3 ║ 4
    ═══╬═══╬═══╬═══
     5 ║ 6 ║$x ║ 8
    ═══╬═══╬═══╬═══
     9 ║$x ║ b ║ c
    ═══╬═══╬═══╬═══
     d ║ e ║ f ║ g
    """
      render(Board('X, Set('B3, 'C2), Set())) should equal (expected)
    }

    it("should display an O on board positions played by the second player") {
      val o = " " + render('O)
      val expected = s"""
     1 ║ 2 ║$o ║ 4
    ═══╬═══╬═══╬═══
     5 ║ 6 ║ 7 ║ 8
    ═══╬═══╬═══╬═══
     9 ║ a ║ b ║ c
    ═══╬═══╬═══╬═══
     d ║ e ║ f ║$o
    """
      render(Board('X, Set(), Set('A3, 'D4))) should equal (expected)
    }
  }
}


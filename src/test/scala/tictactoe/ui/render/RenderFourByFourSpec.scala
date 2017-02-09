package tictactoe.ui.render

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
      render('_1) should equal ("1")
      render('_2) should equal ("2")
      render('_3) should equal ("3")
      render('_4) should equal ("4")
      render('_5) should equal ("5")
      render('_6) should equal ("6")
      render('_7) should equal ("7")
      render('_8) should equal ("8")
      render('_9) should equal ("9")
      render('_a) should equal ("a")
      render('_b) should equal ("b")
      render('_c) should equal ("c")
      render('_d) should equal ("d")
      render('_e) should equal ("e")
      render('_f) should equal ("f")
      render('_g) should equal ("g")
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
      render(Board('X, Set('_7, '_a), Set())) should equal (expected)
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
      render(Board('X, Set(), Set('_3, '_g))) should equal (expected)
    }
  }
}


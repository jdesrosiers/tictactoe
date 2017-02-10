package tictactoeui.classic

import org.scalatest._
import tictactoe.Board

class RenderClassicSpec extends FunSpec with Matchers {
  val render = new RenderClassic()

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
      render('bottomLeft) should equal ("1")
      render('bottomMiddle) should equal ("2")
      render('bottomRight) should equal ("3")
      render('middleLeft) should equal ("4")
      render('center) should equal ("5")
      render('middleRight) should equal ("6")
      render('topLeft) should equal ("7")
      render('topMiddle) should equal ("8")
      render('topRight) should equal ("9")
    }
  }

  describe("A Tic Tac Toe board") {
    it("should show board positions for available moves") {
      val expected = """
     7 ║ 8 ║ 9
    ═══╬═══╬═══
     4 ║ 5 ║ 6
    ═══╬═══╬═══
     1 ║ 2 ║ 3
    """
      render(Board()) should equal (expected)
    }

    it("should display an O on board positions played by the first player") {
      val x = " " + render('X)
      val expected = s"""
    $x ║ 8 ║ 9
    ═══╬═══╬═══
     4 ║$x ║ 6
    ═══╬═══╬═══
     1 ║ 2 ║ 3
    """
      render(Board('X, Set('topLeft, 'center), Set())) should equal (expected)
    }

    it("should display an X on board positions played by the second player") {
      val o = " " + render('O)
      val expected = s"""
     7 ║ 8 ║ 9
    ═══╬═══╬═══
     4 ║ 5 ║$o
    ═══╬═══╬═══
    $o ║ 2 ║ 3
    """
      render(Board('X, Set(), Set('middleRight, 'bottomLeft))) should equal (expected)
    }
  }
}

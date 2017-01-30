import scala.io.StdIn

object App {
  def main(args: Array[String]): Unit = {
    clearConsole
    println("Let's Play Tic Tac Toe!")

    val board = """
     7 ║ 8 ║ 9
    ═══╬═══╬═══
     4 ║ 5 ║ 6
    ═══╬═══╬═══
     7 ║ 8 ║ 9
    """
    println(board)

    print("It's X's turn: ")
    StdIn.readLine
  }

  def clearConsole = print("\u001b[2J\u001b[0;0H")
}

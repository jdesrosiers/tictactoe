import tictactoe.TicTacToe
import tictactoe.player.{ConsolePlayer, MinimaxPlayer}
import tictactoe.ui.TicTacToeUI

object FourByFour {
  val defaultMinimaxDepth = 5

  def main(args: Array[String]): Unit = {
    val defaultOptions = Map(
      'X -> "human",
      'O -> s"minimax,$defaultMinimaxDepth"
    )
    val options = buildOptions(args, defaultOptions)

    val game = TicTacToe.fourByFour
    val playerX = buildPlayer(options('X), game)
    val playerO = buildPlayer(options('O), game)
    TicTacToeUI.fourByFour(game, playerX, playerO).play()
  }

  val option = """--(\w+)=(.+)""".r
  def buildOptions(args: Array[String], defaults: Map[Symbol, String]) = defaults ++ args.map {
    case option(key, value) => (Symbol(key) -> value)
  }

  val minimax = """minimax(?:,(\d+))?""".r
  def buildPlayer(playerType: String, game: TicTacToe) = playerType match {
    case "human" => new ConsolePlayer()
    case minimax(null) => new MinimaxPlayer(game, defaultMinimaxDepth)
    case minimax(depthLimit) => new MinimaxPlayer(game, depthLimit.toInt)
  }
}

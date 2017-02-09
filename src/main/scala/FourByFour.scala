import tictactoe.TicTacToe
import tictactoe.player.{ConsoleFourByFourPlayer, MinimaxPlayer}
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

  private val option = """--(\w+)=(.+)""".r
  private def buildOptions(args: Array[String], defaults: Map[Symbol, String]) = defaults ++ args.map {
    case option(key, value) => Symbol(key) -> value
  }

  private val minimax = """minimax(?:,(\d+))?""".r
  private def buildPlayer(playerType: String, game: TicTacToe) = playerType match {
    case "human" => new ConsoleFourByFourPlayer()
    case minimax(null) => new MinimaxPlayer(game, defaultMinimaxDepth)
    case minimax(depthLimit) => new MinimaxPlayer(game, depthLimit.toInt)
  }
}

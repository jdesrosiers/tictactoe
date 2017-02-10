import tictactoe.TicTacToe
import tictactoeui.MinimaxPlayer
import tictactoeui.TicTacToeUI
import tictactoeui.classic.ConsoleClassicPlayer

object Classic {
  val defaultMinimaxDepth = 6

  def main(args: Array[String]): Unit = {
    val defaults = Map(
      'X -> "human",
      'O -> s"minimax,$defaultMinimaxDepth"
    )
    val options = buildOptions(args, defaults)

    val game = TicTacToe.classic
    val playerX = buildPlayer(options('X), game)
    val playerO = buildPlayer(options('O), game)
    TicTacToeUI.classic(game, playerX, playerO).play()
  }

  private val option = """--(\w+)=(.+)""".r
  private def buildOptions(args: Array[String], defaults: Map[Symbol, String]) = defaults ++ args.map {
    case option(key, value) => Symbol(key) -> value
  }

  private val minimax = """minimax(?:,(\d+))?""".r
  private def buildPlayer(playerType: String, game: TicTacToe) = playerType match {
    case "human" => new ConsoleClassicPlayer()
    case minimax(null) => new MinimaxPlayer(game, defaultMinimaxDepth)
    case minimax(depthLimit) => new MinimaxPlayer(game, depthLimit.toInt)
  }
}

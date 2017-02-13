package tictactoeui

import tictactoe.TicTacToe
import tictactoeui.classic.ConsoleClassicPlayer
import tictactoeui.classic.RenderClassic
import tictactoeui.fourbyfour.ConsoleFourByFourPlayer
import tictactoeui.fourbyfour.RenderFourByFour

class TicTacToeUIFactory(gameVariation: GameVariation, config: Map[Symbol, String]) {
  def build(options: Map[Symbol, String]): TicTacToeUI = {
    val game = gameVariation.game
    val playerX = buildPlayer(options('X), game)
    val playerO = buildPlayer(options('O), game)
    new TicTacToeUI(game, playerX, playerO, gameVariation.renderer)
  }

  private val minimax = """minimax(?:,(\d+))?""".r
  def buildPlayer(playerType: String, game: TicTacToe): Player = playerType match {
    case "human" => gameVariation.humanPlayer
    case minimax(null) => new MinimaxPlayer(game, config('defaultMinimaxDepth).toInt)
    case minimax(depthLimit) => new MinimaxPlayer(game, depthLimit.toInt)
  }
}

case class GameVariation(game: TicTacToe, humanPlayer: Player, renderer: Render)

object GameVariation {
  val classic = GameVariation(TicTacToe.classic, new ConsoleClassicPlayer, new RenderClassic)
  val fourByFour = GameVariation(TicTacToe.fourByFour, new ConsoleFourByFourPlayer, new RenderFourByFour)
}

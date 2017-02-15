package tictactoeui

import eventdispatcher.EventDispatcher
import tictactoe.TicTacToe
import tictactoeui.classic.ConsoleClassicPlayer
import tictactoeui.classic.RenderClassic
import tictactoeui.fourbyfour.ConsoleFourByFourPlayer
import tictactoeui.fourbyfour.RenderFourByFour

class TicTacToeUIFactory(gameVariation: GameVariation, config: Map[Symbol, String]) {
  val dispatcher = new EventDispatcher[Page]
  dispatcher.addListener('play) { page => print(gameVariation.render(page)) }

  def build(options: Map[Symbol, String]): TicTacToeUI = {
    val playerX = buildPlayer(options('X), gameVariation.game)
    val playerO = buildPlayer(options('O), gameVariation.game)
    new TicTacToeUI(gameVariation.game, playerX, playerO, dispatcher)
  }

  private val minimax = """minimax(?:,(\d+))?""".r
  def buildPlayer(playerType: String, game: TicTacToe): Player = playerType match {
    case "human" => gameVariation.humanPlayer
    case minimax(null) => new MinimaxPlayer(game, config('defaultMinimaxDepth).toInt)
    case minimax(depthLimit) => new MinimaxPlayer(game, depthLimit.toInt)
  }
}

case class GameVariation(game: TicTacToe, humanPlayer: Player, render: Render)

object GameVariation {
  val classic = GameVariation(TicTacToe.classic, new ConsoleClassicPlayer, new RenderClassic)
  val fourByFour = GameVariation(TicTacToe.fourByFour, new ConsoleFourByFourPlayer, new RenderFourByFour)
}

import commandline.CommandLine
import tictactoeui.TicTacToeUIFactory
import tictactoeui.GameVariation

object FourByFour {
  def main(args: Array[String]): Unit = {
    val config = Map('defaultMinimaxDepth -> "5")
    val factory = new TicTacToeUIFactory(GameVariation.fourByFour, config)

    val defaultOptions = Map('X -> "human", 'O -> "minimax")
    val options = CommandLine.options(args, defaultOptions)
    factory.build(options).play()
  }
}

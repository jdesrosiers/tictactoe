import commandline.CommandLine
import tictactoeui.TicTacToeUIFactory
import tictactoeui.GameVariation

object Classic {
  def main(args: Array[String]): Unit = {
    val config = Map('defaultMinimaxDepth -> "6")
    val factory = new TicTacToeUIFactory(GameVariation.classic, config)

    val defaultOptions = Map('X -> "human", 'O -> "minimax")
    val options = CommandLine.options(args, defaultOptions)
    factory.build(options).play()
  }
}

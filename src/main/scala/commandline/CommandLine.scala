package commandline

object CommandLine {
  private val option = """--(\w+)=(.+)""".r
  def options(args: Array[String], defaults: Map[Symbol, String]): Map[Symbol, String] =
    defaults ++ args.map {
      case option(key, value) => Symbol(key) -> value
    }
}

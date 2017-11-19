/*
 *
 *                   __     _ _                      _
 *                   \ \   (_) |                    | |
 *   __ _ _   ___  __ \ \   _| |__ ______ ___  _ __ | |_
 *  / _` | | | \ \/ /  > \ | | '_ \______/ _ \| '_ \| __|
 * | (_| | |_| |>  <  / ^ \| | |_) |    | (_) | |_) | |_
 *  \__,_|\__,_/_/\_\/_/ \_\_|_.__/      \___/| .__/ \__|
 *                                            | |
 *                                            |_|
 *
 */

package auxlib.opt

trait MasterOptionParser {

  type Description = String
  type OptionName = String

  private var optToParserExecutable: Map[OptionName, (Description, Array[String] => Unit)] = Map.empty

  protected def addOpt(opt: OptionName,
                  description: Description,
                  executable: Array[String] => Unit): Unit ={
    optToParserExecutable += opt -> (description, executable)
  }

  def parse(argz: Array[String]): Unit = {

    if(argz.isEmpty) {
      println(usage)
      sys.exit(1)
    }

    val firstArgument = argz.head.trim

    optToParserExecutable.get(firstArgument) match {
      case Some((_, executable)) =>
        val restOptions = if(argz.length == 1) Array[String]() else argz.slice(1, argz.length)
        executable(restOptions)

      case None =>
        Console.err.print(s"Unknown parameter '$firstArgument'")
        sys.exit(1)
    }
  }

  def usage: String = {
    val maxSizeOptName = optToParserExecutable.keys.map(_.length).max + 4
    "\n\nUsage:\n" + optToParserExecutable
      .map {
        case (optionName, (description, _)) =>
          val max_length = 76 - maxSizeOptName

          if(max_length < 0)
            s"    $optionName$NLTB${wrapText(description, 72)}"
          else {
            val numberOfwhiteSpaces = maxSizeOptName - optionName.size
            val gap = " " * numberOfwhiteSpaces

            s"    $optionName$gap${wrapText(description, max_length)}"
          }
      }
      .mkString(NL)
  }

}

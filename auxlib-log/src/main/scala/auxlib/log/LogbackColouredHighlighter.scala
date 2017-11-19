/*
 *                   __     _ _           _             
 *                   \ \   (_) |         | |            
 *   __ _ _   ___  __ \ \   _| |__ ______| | ___   __ _ 
 *  / _` | | | \ \/ /  > \ | | '_ \______| |/ _ \ / _` |
 * | (_| | |_| |>  <  / ^ \| | |_) |     | | (_) | (_| |
 *  \__,_|\__,_/_/\_\/_/ \_\_|_.__/      |_|\___/ \__, |
 *                                                 __/ |
 *                                                |___/    
 *
 */

package auxlib.log

import ch.qos.logback.classic.Level
import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase

import scala.annotation.switch

class LogbackColouredHighlighter extends ForegroundCompositeConverterBase[ILoggingEvent] {

  import LogbackColouredHighlighter._

  override def getForegroundColorCode(event: ILoggingEvent): String =
    (event.getLevel.levelInt: @switch) match {
      case Level.ERROR_INT => STYLE_ERROR
      case Level.WARN_INT => STYLE_WARN
      case Level.INFO_INT => STYLE_INFO
      case Level.DEBUG_INT => STYLE_DEBUG
      case Level.TRACE_INT => STYLE_TRACE
      case _ => DEFAULT_FG
    }
}

object LogbackColouredHighlighter {
  val DEFAULT_FG: String = "39"
  val STYLE_ERROR = "31" // Red
  val STYLE_WARN = "33" // Orange
  val STYLE_INFO = "32" // Green
  val STYLE_DEBUG = "34" // Blue
  val STYLE_TRACE = "35" // Magenta
}

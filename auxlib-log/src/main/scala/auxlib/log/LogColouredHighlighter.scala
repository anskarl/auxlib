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
 * Copyright (C) 2014  Anastasios Skarlatidis.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published 
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/lgpl-3.0.html>.
 */

package auxlib.log

import ch.qos.logback.classic.Level
import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase

import scala.annotation.switch

/**
 * @author Anastasios Skarlatidis
 */
final class LogColouredHighlighter extends ForegroundCompositeConverterBase[ILoggingEvent]{
  private val DEFAULT_FG: String = "39"
  private val STYLE_ERROR = "31" // Red
  private val STYLE_WARN = "33" // Orange
  private val STYLE_INFO = "32" // Green
  private val STYLE_DEBUG = "35" // Magenta
  private val STYLE_TRACE = "35" // Magenta

  override def getForegroundColorCode(event: ILoggingEvent): String =
    ( event.getLevel.toInt: @switch) match {
      case Level.ERROR_INT => STYLE_ERROR
      case Level.WARN_INT => STYLE_WARN
      case Level.INFO_INT => STYLE_INFO
      case Level.DEBUG_INT => STYLE_DEBUG
      case Level.TRACE_INT => STYLE_TRACE
      case _ => DEFAULT_FG
    }



}

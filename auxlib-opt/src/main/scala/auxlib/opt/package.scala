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

package auxlib

package object opt {

  final val NL = System.getProperty("line.separator")
  final val TB = "        " //8 whitespace chars
  final val NLTB = NL + TB
  final val NLNL = NL + NL

  final val defaultKeyName = "<key>"
  final val defaultValueName = "<value>"

  def wrapText(description: String, maxLength: Int): String = {
    if(description.length < maxLength) description
    else if(description.substring(0,maxLength).contains(NL)){
      val idxNL = description.indexOf(NL)
      description.substring(0, idxNL).trim() +NLTB+wrapText(description.substring(idxNL+1).trim(), maxLength)
    }
    else{
      val idx = math.max(math.max(description.lastIndexOf(" ", maxLength), description.lastIndexOf(TB,maxLength)), description.lastIndexOf("-",maxLength))
      description.substring(0, idx).trim()+NLTB+wrapText(description.substring(idx).trim(), maxLength)
    }
  }
}

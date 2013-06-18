/*
* This file is part of the ToolXiT project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package toolxit.util

import scala.util.parsing.input.Position

/** A position that has no context in the stream for what was read before and
 *  what comes next. It is only aware of the current token
 *
 *  @author Lucas Satabin
 */
abstract class StreamPosition[T: Manifest] extends Position {

  val read: Option[T]

  val offset: Int

  def lineContents: String =
    read.map(_.toString).getOrElse("<EOI>")

  def next(read: T): StreamPosition[T]

  /** Returns a string representation of the `Position`, of the form `[line.column]`. */
  override def toString = s"[$line.$column]"

  override def <(that: Position) = that match {
    case that: StreamPosition[T] =>
      this.offset < that.offset
    case _ =>
      super.<(that)
  }
}


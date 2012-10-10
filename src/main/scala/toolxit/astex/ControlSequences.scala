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
package toolxit.astex

import dimen._

/** TeX basically has very few types:
 *   - signed integer
 *   - character
 *   - math character
 *   - dimension
 *   - glue
 *   - muglue
 *   - macro (defined by a user, which is basically a function type)
 *   - built-in macros which are also function types but
 *   - token lists
 *   - font
 *
 *  @author Lucas Satabin
 *
 */
object TeXType extends Enumeration {
  val TeXInteger = Value
  val TeXChar = Value
  val TeXMathChar = Value
  val TeXDimension = Value
  val TeXGlue = Value
  val TeXMuglue = Value
  val TeXMacro = Value
  val TeXBuiltin = Value
  val TeXTokenList = Value
  val TeXFont = Value
}

sealed trait ControlSequence {
  val name: String
  val tpe: TeXType.Value
}

final case class TeXInteger(name: String,
                            number: Byte) extends ControlSequence {
  val tpe = TeXType.TeXInteger
}

final case class TeXChar(name: String,
                         number: Byte) extends ControlSequence {
  val tpe = TeXType.TeXChar
}

final case class TeXMathChar(name: String,
                             number: Byte) extends ControlSequence {
  val tpe = TeXType.TeXMathChar
}

final case class TeXDimension(name: String,
                              number: Byte) extends ControlSequence {
  val tpe = TeXType.TeXDimension
}

final case class TeXGlue(name: String,
                         number: Byte) extends ControlSequence {
  val tpe = TeXType.TeXGlue
}

final case class TeXMuglue(name: String,
                           number: Byte) extends ControlSequence {
  val tpe = TeXType.TeXMuglue
}

final case class TeXMacro(name: String,
                          parameters: List[Parameter],
                          replacement: List[Token]) extends ControlSequence {
  val tpe = TeXType.TeXMacro
}

final case class TeXBuiltin(name: String) extends ControlSequence {
  val tpe = TeXType.TeXBuiltin
}

final case class TeXTokenList(name: String,
                              number: Byte) extends ControlSequence {
  val tpe = TeXType.TeXTokenList
}

final case class TeXFont(name: String,
                         number: Byte) extends ControlSequence {
  val tpe = TeXType.TeXFont
}
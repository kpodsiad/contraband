package sbt.contraband

import java.io.File

object GraphQLExample {
  val simpleEnumerationExample = """
package com.example @target(Scala)

## Example of an enumeration
enum EnumExample {
  ## First symbol
  First
  Second

  #x // Some extra code
}"""

  val recordExample = """
package com.example @target(Scala)

## Example of a type
type TypeExample {
  ## something
  field: java.net.URL

  #x // Some extra code
}"""

  val recordExtraIntfExample = """
package com.example @target(Scala)

## Example of a type
type TypeExample {
  ## something
  field: java.net.URL

  #xinterface Intf1
}"""

  val stringStringMapExample = """
package com.example @target(Scala)

## Example of a type
type TypeExample {
  field: StringStringMap!
}"""

  val modifierExample = """
package com.example @target(Scala)

type ModifierExample
@modifier("sealed")
{
  field: Int!
}
"""

  val intfExample = """
package com.example @target(Scala)
@codecPackage("generated")

## Example of an interface
interface InterfaceExample {
  field: Int

  #x // Some extra code
}

type ChildType implements InterfaceExample {
  name: String
  field: Int
}
"""

  val intfExampleWithEmbed = """
package com.example @target(Scala)
@codecPackage("generated")

## Example of an interface
interface InterfaceExample {}

type ChildType implements InterfaceExample {
  detail: [com.example.TestItemDetail]
}

type TestItemDetail {
  ## Indicates whether the event represents a test success, failure, error, skipped, ignored, canceled, pending.
  status: com.example.Status!
}
"""

  val twoLevelIntfExample = """
package com.example @target(Scala)
@codecPackage("generated")

## Example of an interface
interface InterfaceExample {
  field: Int
}

interface MiddleInterface implements InterfaceExample
@generateCodec(false)
{
  field: Int
}

type ChildType implements MiddleInterface {
  name: String
  field: Int
}
"""

  val messageExample = """
package com.example @target(Scala) @codecPackage("generated")

interface IntfExample {
  ## I'm a field.
  field: Int

  ## A very simple example of a message.
  ## Messages can only appear in interface definitions.
  messageExample(
    ## The first argument of the message.
    ## Make sure it is awesome.
    arg0: lazy [Int]

    ## This argument is not important, so it gets single line doc.
    arg1: Boolean): [Int]
}
"""

  val customizationExample = """
package com.example @target(Scala) @codecPackage("generated")

## Example of an interface
interface IntfExample {
  field: Int

  #x // Some extra code...
  #xinterface Interface1
  #xinterface Interface2
  #xtostring return "custom";
  #xcompanion // Some extra companion code...
  #xcompanioninterface CompanionInterface1
  #xcompanioninterface CompanionInterface2
}
"""

  val growableAddOneFieldExample = """
package com.example @target(Scala) @codecPackage("generated")

type Growable @target(Scala) {
  field: Int = 0 @since("0.1.0")
}
"""

  val growableZeroToOneToTwoFieldsExample = """
package com.example @target(Scala) @codecPackage("generated")

type Foo @target(Scala) {
  x: Int @since("0.1.0")
  y: [Int] @since("0.2.0")
}
""".stripMargin

  val mixedExample = """
package com.example @target(Scala) @codecPackage("generated")

interface Greeting @target(Java) {
  message: String!
  s: String = raw"java.util.Optional.<String>ofNullable(\"1\")" @since("0.1.0")
}

type SimpleGreeting implements Greeting @target(Scala) {
  message: String!
  s: String = raw"java.util.Optional.ofNullable[String](\"1\")" @since("0.1.0")
}
""".stripMargin
}

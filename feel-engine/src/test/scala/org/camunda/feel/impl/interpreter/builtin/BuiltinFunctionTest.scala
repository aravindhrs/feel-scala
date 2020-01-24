package org.camunda.feel.impl.interpreter.builtin

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.camunda.feel.impl._
import org.camunda.feel.impl.interpreter._
import org.camunda.feel.impl.interpreter.FeelIntegrationTest
import scala.math.BigDecimal.double2bigDecimal
import scala.math.BigDecimal.int2bigDecimal

/**
  * @author Philipp
  */
class BuiltinFunctionsTest
    extends FlatSpec
    with Matchers
    with FeelIntegrationTest {

  "A built-in function" should "return null if arguments doesn't match" in {

    eval("date(true)") should be(ValNull)
    eval("number(false)") should be(ValNull)
  }

  "A not() function" should "negate Boolean" in {

    eval(" not(true) ") should be(ValBoolean(false))
    eval(" not(false) ") should be(ValBoolean(true))
  }

}

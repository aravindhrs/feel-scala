/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.feel.interpreter.impl

import org.scalatest.{FlatSpec, Matchers}
import org.camunda.feel.syntaxtree._

/**
  * @author Philipp Ossler
  */
class InterpreterStringExpressionTest
    extends FlatSpec
    with Matchers
    with FeelIntegrationTest {

  "A string" should "concatenates to another String" in {

    eval(""" "a" + "b" """) should be(ValString("ab"))
  }

  it should "compare with '='" in {

    eval(""" "a" = "a" """) should be(ValBoolean(true))
    eval(""" "a" = "b" """) should be(ValBoolean(false))
  }

  it should "compare with '!='" in {

    eval(""" "a" != "a" """) should be(ValBoolean(false))
    eval(""" "a" != "b" """) should be(ValBoolean(true))
  }

  it should "compare with '<'" in {

    eval(""" "a" < "b" """) should be(ValBoolean(true))
    eval(""" "b" < "a" """) should be(ValBoolean(false))
  }

  it should "compare with '<='" in {

    eval(""" "a" <= "a" """) should be(ValBoolean(true))
    eval(""" "b" <= "a" """) should be(ValBoolean(false))
  }

  it should "compare with '>'" in {

    eval(""" "b" > "a" """) should be(ValBoolean(true))
    eval(""" "a" > "b" """) should be(ValBoolean(false))
  }

  it should "compare with '>='" in {

    eval(""" "b" >= "b" """) should be(ValBoolean(true))
    eval(""" "a" >= "b" """) should be(ValBoolean(false))
  }

  it should "compare with null" in {

    eval(""" "a" = null """) should be(ValBoolean(false))
    eval(""" null = "a" """) should be(ValBoolean(false))
    eval(""" "a" != null """) should be(ValBoolean(true))
  }

}

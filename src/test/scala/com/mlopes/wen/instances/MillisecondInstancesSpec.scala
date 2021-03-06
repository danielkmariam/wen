package com.mlopes.wen.instances

import cats.Eq
import cats.implicits._
import com.mlopes.wen.instances.MillisecondInstances._
import com.mlopes.wen.types.Millisecond
import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.{Matchers, WordSpec}

class MillisecondInstancesSpec extends WordSpec with Matchers with TypeCheckedTripleEquals {

  "Millisecond Instances" should {
    "provide order" in {
      val millisecond1 = Millisecond(257).get
      val millisecond2 = Millisecond(36).get
      val millisecond3 = Millisecond(481).get
      (millisecond1 compare millisecond1) should ===(0)
      (millisecond1 compare millisecond2) > 0 should ===(true)
      (millisecond2 compare millisecond3) < 0 should ===(true)
    }

    "provide eq" in {
      val millisecond1 = Millisecond(8).get
      val millisecond2 = Millisecond(143).get
      val millisecond3 = Millisecond(540).get

      Eq[Millisecond].eqv(millisecond1, millisecond1) should ===(true)
      Eq[Millisecond].neqv(millisecond1, millisecond2) should ===(true)
      Eq[Millisecond].neqv(millisecond2, millisecond3) should ===(true)
    }

    "provide show" in {
      val millisecond1 = Millisecond(2).get
      val millisecond2 = Millisecond(999).get

      millisecond1.show should ===("2")
      millisecond2.show should ===("999")
    }
  }
}

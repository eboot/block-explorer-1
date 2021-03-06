package com.xsn.explorer.models

import org.scalatest.{MustMatchers, OptionValues, WordSpec}

class AddressSpec extends WordSpec with MustMatchers with OptionValues {

  "from" should {
    "allow to create a legacy address" in {
      val input = "Xvjue2ZLnJwTrSLUBx7DTHaSHTdpWrxtLF"
      val result = Address.from(input)
      result.value.string mustEqual input
    }

    "allow to create a P2WPKH address" in {
      val input = "bc1qzhayf65p2j4h3pfw22aujgr5w42xfqzx5uvddt"
      val result = Address.from(input)
      result.value.string mustEqual input
    }

    "reject an empty string" in {
      val input = ""
      val result = Address.from(input)
      result mustEqual Option.empty
    }

    "reject whitespaces" in {
      val input = " Xvjue2ZLnJwTrSLUBx7DTHaSHTdpWrxtLF "
      val result = Address.from(input)
      result mustEqual Option.empty
    }

    "reject invalid characters" in {
      val input = "bc1qzhayf65p2j4h3pfw22aujgr5w42xfqzx.uvddt"
      val result = Address.from(input)
      result mustEqual Option.empty
    }

    "reject invalid address, 1 character missing" in {
      val input = "Xvjue2ZLnJwTrSLUBx7DTHaSHTdpWrxtL"
      val result = Address.from(input)
      result mustEqual Option.empty
    }

    "reject invalid address, 1 extra character" in {
      val input = "Xvjue2ZLnJwTrSLUBx7DTHaSHTdpWrxtLFf"
      val result = Address.from(input)
      result mustEqual Option.empty
    }

    "reject invalid address, 1 character missing on P2WPKH" in {
      val input = "bc1qzhayf65p2j4h3pfw22aujgr5w42xfqzx5uvdd"
      val result = Address.from(input)
      result mustEqual Option.empty
    }

    "reject invalid address, 1 extra character on P2WPKH" in {
      val input = "bc1qzhayf65p2j4h3pfw22aujgr5w42xfqzx5uvddt1"
      val result = Address.from(input)
      result mustEqual Option.empty
    }
  }
}

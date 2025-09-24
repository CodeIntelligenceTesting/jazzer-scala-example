package com.example

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.DisplayName

import com.code_intelligence.jazzer.junit.FuzzTest

class ExploreMeTest {

  @Test
  @DisplayName("Should return a success message for safe input")
  def testSafeInput(): Unit = {
    val result = ExploreMe.processInput(10, 20, "SafeUser")
    assertEquals("Input processed successfully.", result)
  }

  @Test
  @DisplayName("Should throw DangerousInputException for the specific combination")
  def testDangerousCombination(): Unit = {
    // assertThrows is the JUnit 5 way to check for exceptions.
    val exception = assertThrows(
      classOf[DangerousInputException],
      () => ExploreMe.processInput(1000, 2000, "Attacker")
    )

    // You can also assert the message of the exception
    assertEquals("Forbidden combination detected!", exception.getMessage)
  }

  @Test
  @DisplayName("Should not throw if only 'a' and 'b' match")
  def testPartialMatchAB(): Unit = {
    val result = ExploreMe.processInput(1000, 2000, "NotAttacker")
    assertEquals("Input processed successfully.", result)
  }

  @Test
  @DisplayName("Should not throw if only 's' matches")
  def testPartialMatchS(): Unit = {
    val result = ExploreMe.processInput(1, 2, "Attacker")
    assertEquals("Input processed successfully.", result)
  }

  @Test
  @DisplayName("Should not throw for another combination")
  def testOtherInput(): Unit = {
    val result = ExploreMe.processInput(1000, 2001, "Attacker")
    assertEquals("Input processed successfully.", result)
  }

  @FuzzTest
  def myFuzzTest(a: Int, b: Int, s: String): Unit = {
    ExploreMe.processInput(a, b, s)
  }
}
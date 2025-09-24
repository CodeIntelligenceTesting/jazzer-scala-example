package com.example

/**
 * A custom exception for our specific error case.
 */
class DangerousInputException(message: String) extends Exception(message)

object ExploreMe {

  /**
   * Processes input and throws an exception for a specific combination.
   *
   * @param a   First integer
   * @param b   Second integer
   * @param s   Input string
   * @return    A success message if no exception is thrown
   * @throws    DangerousInputException if the combination (1000, 2000, "Attacker") is met
   */
  def processInput(a: Int, b: Int, s: String): String = {
    if (a == 1000 && b == 2000 && s == "Attacker") {
      throw new DangerousInputException("Dangerous combination detected!")
    } else {
      "Input processed successfully."
    }
  }
}
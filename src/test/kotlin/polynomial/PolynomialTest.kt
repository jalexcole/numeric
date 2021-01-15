package polynomial


import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PolynomialTest {
  
  @Test
  fun integrate() {
    val expected = Polynomial(arrayOf(0.0, 1.0, 1.0, 1.0))
    val actual = Polynomial(arrayOf(1.0, 2.0, 3.0)).integrate()
    assert(expected.equals(actual))
  }
  
  @Test
  fun derivative() {
  }
  
  @Test
  operator fun invoke() {
  }
  
  
  @Test
  fun plus() {
  
  }
  
  @Test
  fun minus() {
  }
  
  @Test
  fun times() {
  }
  
  @Test
  fun div() {
  }
  
  @Test
  fun toArrayND() {
  }
}
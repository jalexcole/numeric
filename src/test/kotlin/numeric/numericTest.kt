package numeric

import arrayND.ArrayND
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class NumericTest {
  val nm = numeric
  @Test
  fun aRangeOf() {
    val test = ArrayND(arrayOf(0.0, 1.0, 2.0, 3.0, 4.0))
    val actual = nm.aRangeOf(5)
    
    assertTrue(test.equals(actual))
  }
  
  @Test
  fun arrayNDOf() {
    val testValues = arrayOf(1.0, 2.0, 3.0)
    val expected = ArrayND(testValues)
    
    val actual = nm.arrayNDOf(testValues)
    
    assertTrue(expected.equals(actual))
  }
  
  @Test
  fun linspace() {
    val expected = nm.arrayNDOf(0.0, 1.0, 2.0, 3.0, 4.0)
    val actual = nm.linspace(0.0, 4.0, 5)
    
    assertTrue(expected.equals(actual))
  }
  
  @Test
  fun randomND() {
    // Need to learn how to test this value
    val x = nm.randomND(10)
    assertTrue(true)
  }
  
  @Test
  fun dotProduct() {
    val expected = 14.0
    val test = nm.arrayNDOf(1.0, 2.0, 3.0)
    val actual = nm.dotProduct(test, test).single()
    println(actual)
    assertTrue(expected.equals(actual))
  }
  
  @Test
  fun zeros() {
    val expected = nm.arrayNDOf(0.0, 0.0, 0.0)
    val actual = nm.zeros(3)
    
    assertTrue(expected.equals(actual))
  }
}
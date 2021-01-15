package numeric

import arrayND.ArrayND
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class numericTest {
  
  @Test
  fun aRangeOf() {
    val test = arrayOf(0.0, 1.0, 2.0, 3.0, 4.0)
    val actual = aRangeOf(5)
    
    assertTrue(test.contentEquals(actual.elements))
  }
  
  @Test
  fun arrayNDOf() {
    val testValues = arrayOf(1.0, 2.0, 3.0)
    val expected = ArrayND(testValues)
    
    val actual = arrayNDOf(testValues)
    
    assertTrue(expected.equals(actual))
  }
  
  @Test
  fun linspace() {
    val expected = arrayNDOf(0.0, 1.0, 2.0, 3.0, 4.0)
    val actual = linspace(0.0, 4.0, 5)
    
    assertTrue(expected.equals(actual))
  }
  
  @Test
  fun randomND() {
    // Need to learn how to test this value
    val x = randomND(10)
    assertTrue(true)
  }
  
  @Test
  fun dotProduct() {
    val expected = 14.0
    val test = arrayNDOf(1.0, 2.0, 3.0)
    val actual = dotProduct(test, test).single()
    println(actual)
    assertTrue(expected.equals(actual))
  }
  
  @Test
  fun zeros() {
    val expected = arrayNDOf(0.0, 0.0, 0.0)
    val actual = zeros(3)
    
    assertTrue(expected.equals(actual))
  }
}
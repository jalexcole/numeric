package numeric

import arrayND.ArrayND
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import numeric.*

internal class numericTest {
  
  @Test
  fun aRangeOf() {
    val test = arrayOf(0.0, 1.0, 2.0, 3.0, 4.0)
    val actual = aRangeOf(5)
    
    assertTrue(test.contentEquals(actual.dataElements))
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
  }
  
  @Test
  fun randomND() {
  }
  
  @Test
  fun testRandomND() {
  }
  
  @Test
  fun dotProduct() {
  }
  
  @Test
  fun zeros() {
  }
}
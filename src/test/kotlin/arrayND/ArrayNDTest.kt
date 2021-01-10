package arrayND

import aRangeOf
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ArrayNDTest {
  val test1D = aRangeOf(64)
  val test2D = test1D.reshape(arrayOf(8,8))
  val test3D = aRangeOf(64).reshape(arrayOf(4, 4, 4))
  
  
  @Test
  fun reshape() {
  }
  
  @Test
  fun toTypedArray() {
  }
  
  @Test
  fun plus() {
  }
  
  @Test
  fun print() {
  }
  
  @Test
  fun get() {
    val oneDExpected = 17.0
    val oneDTest = test1D[17].single()
    
    val twoDimensionExpected = 38.0
    val twoDimensionTest = test2D[4,6].single()
    
    val threeDimensionExpected = 46.0
    val threeDimensionTest = test3D[2,3,2].single()
    
    assertEquals(oneDExpected, oneDTest)
    assertEquals(twoDimensionExpected, threeDimensionTest)
    assertEquals(threeDimensionExpected, threeDimensionTest)
  }
  
  @Test
  fun set() {
    val expectedValue = 14.0
    
    
    val testSubject = test2D
    testSubject[3, 5] = 14.0
    
    assertEquals(expectedValue, testSubject[3, 5].single())
    
  }
  
  @Test
  fun single() {
  }
  
  @Test
  fun testPlus() {
  }
}
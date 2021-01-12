package arrayND

import aRangeOf
import arrayNDOf
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ArrayNDTest {
  private val testValue = 64
  private val test1D = aRangeOf(testValue)
  private val test2D = test1D.reshape(arrayOf(8,8))
  private val test3D = aRangeOf(64).reshape(arrayOf(4, 4, 4))
  
  @Test
  fun reshape() {
    val expectedReshape = aRangeOf(64)
    val actualReshape = test2D.reshape(arrayOf(8,8))
    assertEquals(expectedReshape, actualReshape)
  }
  
  @Test
  fun plus() {
    val expectedValue = arrayNDOf(2.0, 4.0, 6.0)
    val actualValue = arrayNDOf(1.0, 2.0, 3.0) + arrayNDOf(1.0, 2.0, 3.0)
    
    assertTrue(expectedValue.equals(actualValue))
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
    assertEquals(twoDimensionExpected, twoDimensionTest)
    assertEquals(threeDimensionExpected, threeDimensionTest)
  }
  
  @Test
  fun set() {
    val expectedValue = 14.0
    
    val testSubject = test2D
    testSubject[3, 5] = expectedValue
    
    assertEquals(expectedValue, testSubject[3, 5].single())
    
  }
  
  @Test
  fun single() {
    // val test1 = arrayNDOf(1.0, 2.0)
    val expectedSingle = 1.0
    val test2 = arrayNDOf(expectedSingle)
    
    assertEquals(expectedSingle, test2.single())
  }
  
  @Test
  fun getShape1() {
    assertEquals(arrayOf(8,8), test2D.getShape())
  }
  
  @Test
  fun minus() {
    val expected = arrayNDOf(0.0, 0.0, 0.0)
    val actual = arrayNDOf(1.0, 2.0, 3.0) - arrayNDOf(1.0, 2.0, 3.0)
  
    assertTrue(expected.dataElements == actual.dataElements && expected.shape == actual.shape)
  }
  
  
  @Test
  fun unaryMinus() {
    val expected = arrayNDOf(2.0, 4.0, 6.0)
    val actual = -arrayNDOf(-2.0, -4.0, -6.0)
  
    assertTrue(expected.dataElements == actual.dataElements
            && expected.shape == actual.shape)
  }
  
  @Test
  fun times() {
    val expected = arrayNDOf(1.0, 4.0, 9.0)
    val actual = arrayNDOf(1.0, 2.0, 3.0) * arrayNDOf(1.0, 2.0, 3.0)
    
    assertTrue(expected.dataElements == actual.dataElements && expected.shape == actual.shape)
  }
  
  
  @Test
  fun div() {
    val expected = arrayNDOf(1.0, 1.0, 1.0)
    val actual = arrayNDOf(1.0, 2.0, 3.0) / arrayNDOf(1.0, 2.0, 3.0)
  
    assertTrue(expected.dataElements == actual.dataElements && expected.shape == actual.shape)
  }
  
  
  @Test
  fun equals() {
  }
  
  @Test
  fun toPolynomial() {
    val expected = 17.0
    var x = arrayNDOf(1.0, 2.0, 3.0).toPolynomial()
    assertEquals(expected, x(2.0))
  }
  
  @Test
  fun isScalar() {
    val expectedTrue = arrayNDOf(6.022e23)
    val expectedFalse = arrayNDOf(1.0, 2.0)
    
    assertEquals(expectedTrue, true)
    assertEquals(expectedFalse, false)
  }
  
  @Test
  fun isVector() {
    val expectedFalse = arrayNDOf(6.022e23)
    val expectedTrue = arrayNDOf(1.0, 2.0)
  
    assertEquals(expectedTrue, true)
    assertEquals(expectedFalse, false)
  }
  
  @Test
  fun isEmpty() {
    val expectedFalse1 = arrayNDOf(6.022e23)
    val expectedFalse2 = arrayNDOf(1.0, 2.0)
    val expectedTrue = arrayNDOf()
    assertEquals(expectedTrue, true)
    assertEquals(expectedFalse1, false)
    assertEquals(expectedFalse2, false)
  }
}
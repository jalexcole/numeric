package arrayND

import aRangeOf
import arrayNDOf
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.fail
import java.util.*

internal class ArrayNDTest {
  private val testValue = 64
  private val test1D = aRangeOf(testValue)
  private val test2D = test1D.reshape(arrayOf(8,8))
  private val test3D = aRangeOf(64).reshape(arrayOf(4, 4, 4))
  
  @Test
  fun reshape() {
    val expected = aRangeOf(64)
    val actual = test2D.reshape(arrayOf(64))
    val failMessage = "Array did not reshape. Expected array size: ${Arrays.toString(expected.getShape())} not " +
            "${Arrays.toString(actual.getShape())}"
    assertTrue(expected.getShape().contentEquals(actual.getShape()), failMessage)
    
  }
  
  @Test
  fun plus() {
    val expected = arrayNDOf(2.0, 4.0, 6.0)
    val actual = arrayNDOf(1.0, 2.0, 3.0) + arrayNDOf(1.0, 2.0, 3.0)
  
    val failMessage = "Expected vector: ${Arrays.toString(expected.dataElements)} received " +
            "${Arrays.toString(actual.dataElements)}"
    
    assertTrue(expected.dataElements.contentEquals(actual.dataElements)
            && expected.shape.contentEquals(actual.shape), failMessage)
  }
  
  @Test
  fun print() {
    // fail("Print() test is not implemented")
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
  
    val failMessage = "Expected vector: ${Arrays.toString(expected.dataElements)} received " +
            "${Arrays.toString(actual.dataElements)}"
  
    assertTrue(expected.dataElements.contentEquals(actual.dataElements)
            && expected.shape.contentEquals(actual.shape), failMessage)
  }
  
  
  @Test
  fun unaryMinus() {
    val expected = arrayNDOf(2.0, 4.0, 6.0)
    val actual = -arrayNDOf(-2.0, -4.0, -6.0)
  
    val failMessage = "Expected vector: ${Arrays.toString(expected.dataElements)} received " +
            "${Arrays.toString(actual.dataElements)}"
    
    assertTrue(expected.dataElements.contentEquals(actual.dataElements)
            && expected.shape.contentEquals(actual.shape), failMessage)
  }
  
  @Test
  fun times() {
    val expected = arrayNDOf(1.0, 4.0, 9.0)
    val actual = arrayNDOf(1.0, 2.0, 3.0) * arrayNDOf(1.0, 2.0, 3.0)
  
    val failMessage = "Expected vector: ${Arrays.toString(expected.dataElements)} received " +
            "${Arrays.toString(actual.dataElements)}"
    
    assertTrue(expected.dataElements.contentEquals(actual.dataElements)
            && expected.shape.contentEquals(actual.shape), failMessage)
  }
  
  
  @Test
  fun div() {
    val expected = arrayNDOf(1.0, 1.0, 1.0)
    val actual = arrayNDOf(1.0, 2.0, 3.0) / (arrayNDOf(1.0, 2.0, 3.0))
    val failMessage = "Expected vector: ${Arrays.toString(expected.dataElements)} received " +
            "${Arrays.toString(actual.dataElements)}"
    assertTrue(expected.dataElements.contentEquals(actual.dataElements)
            && expected.shape.contentEquals(actual.shape), failMessage)
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
    val expectedTrue = arrayNDOf(6.022e23).isScalar()
    val expectedFalse = arrayNDOf(1.0, 2.0).isScalar()
    
    assertEquals(expectedTrue, true)
    assertEquals(expectedFalse, false)
  }
  
  @Test
  fun isVector() {
    val expectedFalse = aRangeOf(20).reshape(4, 5).isVector()
    val expectedTrue = arrayNDOf(1.0, 2.0).isVector()
  
    assertEquals(expectedTrue, true)
    assertEquals(expectedFalse, false)
  }
  
  @Test
  fun isEmpty() {
    val expectedFalse1 = arrayNDOf(6.022e23).isEmpty()
    val expectedFalse2 = arrayNDOf(1.0, 2.0).isEmpty()
    val expectedTrue = arrayNDOf().isEmpty()
    
    assertEquals(expectedTrue, true)
    assertEquals(expectedFalse1, false)
    assertEquals(expectedFalse2, false)
  }
  
}
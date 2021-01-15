package arrayND

import numeric.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ArrayNDTest {
  private val testValue = 64
  private val test1D = aRangeOf(testValue)
  private val test2D = test1D.reshape(arrayOf(8,8))
  private val test3D = aRangeOf(64).reshape(arrayOf(4, 4, 4))
  
  @Test
  fun reshape() {
    val expected = aRangeOf(64)
    val actual = test2D.reshape(arrayOf(64))
    val failMessage = "Array did not reshape. Expected array size: ${expected.getShape().contentToString()} not " +
            "${actual.getShape().contentToString()}"
    assertTrue(expected.getShape().contentEquals(actual.getShape()), failMessage)
    
  }
  
  @Test
  fun plus() {
    val expected = arrayNDOf(2.0, 4.0, 6.0)
    val actualDouble = arrayNDOf(1.0, 3.0, 5.0) + 1.0
    val actualSingle = arrayNDOf(1.0, 3.0, 5.0) + (arrayNDOf(1.0))
    val actualVector = arrayNDOf(1.0, 2.0, 3.0) + (arrayNDOf(1.0, 2.0, 3.0))
  
    val failMessageDouble = "Failure: ArrayND + Double " +
            "\nExpected vector: ${expected.elements.contentToString()} received " +
            "${actualDouble.elements.contentToString()}"
  
    val failMessageSingle = "Failure: ArrayND + ArrayND.single()" +
            "\nExpected vector: ${expected.elements.contentToString()} received " +
            "${actualSingle.elements.contentToString()}"
    
    val failMessageVector = "Failure: ArrayND + ArrayND" +
            "\nExpected vector: ${expected.elements.contentToString()} received " +
            "${actualVector.elements.contentToString()}"
  
    assertTrue(expected.elements.contentEquals(actualDouble.elements)
            && expected.shape.contentEquals(actualDouble.shape), failMessageDouble)
  
    assertTrue(expected.elements.contentEquals(actualSingle.elements)
            && expected.shape.contentEquals(actualSingle.shape), failMessageSingle)
    
    assertTrue(expected.elements.contentEquals(actualVector.elements)
            && expected.shape.contentEquals(actualVector.shape), failMessageVector)
  }
  
  @Test
  fun contentToString() {
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
    assertTrue(arrayOf(8,8).contentEquals(test2D.getShape()))
  }
  
  @Test
  fun minus() {
    val expected = arrayNDOf(0.0, 0.0, 0.0)
    val actual = arrayNDOf(1.0, 2.0, 3.0) - arrayNDOf(1.0, 2.0, 3.0)
  
    val failMessage = "Expected vector: ${expected.elements.contentToString()} received " +
            "${actual.elements.contentToString()}"
  
    assertTrue(expected.elements.contentEquals(actual.elements)
            && expected.shape.contentEquals(actual.shape), failMessage)
  }
  
  
  @Test
  fun unaryMinus() {
    val expected = arrayNDOf(2.0, 4.0, 6.0)
    val actual = -arrayNDOf(-2.0, -4.0, -6.0)
  
    val failMessage = "Expected vector: ${expected.elements.contentToString()} received " +
            "${actual.elements.contentToString()}"
    
    assertTrue(expected.elements.contentEquals(actual.elements)
            && expected.shape.contentEquals(actual.shape), failMessage)
  }
  
  @Test
  fun times() {
    val expected = arrayNDOf(1.0, 4.0, 9.0)
    val actual = arrayNDOf(1.0, 2.0, 3.0) * arrayNDOf(1.0, 2.0, 3.0)
  
    val failMessage = "Expected vector: ${expected.elements.contentToString()} received " +
            "${actual.elements.contentToString()}"
    
    assertTrue(expected.elements.contentEquals(actual.elements)
            && expected.shape.contentEquals(actual.shape), failMessage)
  }
  
  
  @Test
  fun div() {
    val expected = arrayNDOf(1.0, 1.0, 1.0)
    val actual = arrayNDOf(1.0, 2.0, 3.0) / (arrayNDOf(1.0, 2.0, 3.0))
    val failMessage = "Expected vector: ${expected.elements.contentToString()} received " +
            "${actual.elements.contentToString()}"
    assertTrue(expected.elements.contentEquals(actual.elements)
            && expected.shape.contentEquals(actual.shape), failMessage)
  }
  
  
  @Test
  fun equals() {
    val a = aRangeOf(2)
    val b = aRangeOf(2)
    assertTrue(a.equals(b))
  }
  
  @Test
  fun toPolynomial() {
    val expected = arrayNDOf(17.0)
    var x = arrayNDOf(1.0, 2.0, 3.0).toPolynomial()
    val actual = x(2.0)
    val failMessage = "Fail: toPolynomial()" +
            "\nExpected vector: ${expected.elements.contentToString()} received " +
            "${actual.elements.contentToString()}"
    
    assertTrue(expected.equals(actual), failMessage)
    // assertEquals(expected, x(2.0))
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
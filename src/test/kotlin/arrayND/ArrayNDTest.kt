package arrayND

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ArrayNDTest {
  private val testValue = 64
  private val test1D = ArrayND(arrayOf(
     0.0,  1.0,  2.0,  3.0,  4.0,  5.0,  6.0,  7.0,
     8.0,  9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0,
    16.0, 17.0, 18.0, 19.0, 20.0, 21.0, 22.0, 23.0,
    24.0, 25.0, 26.0, 27.0, 28.0, 29.0, 30.0, 31.0,
    32.0, 33.0, 34.0, 35.0, 36.0, 37.0, 38.0, 39.0,
    40.0, 41.0, 42.0, 43.0, 44.0, 45.0, 46.0, 47.0,
    48.0, 49.0, 50.0, 51.0, 52.0, 53.0, 54.0, 55.0,
    56.0, 57.0, 58.0, 59.0, 60.0, 61.0, 62.0, 63.0))
  private val test2D = test1D.reshape(arrayOf(8, 8))
  private val test3D = test1D.reshape(arrayOf(4, 4, 4))
  
  @Test
  fun reshape() {
    val expected = test1D
    val actual = test2D.reshape(arrayOf(64))
    val failMessage =
      "Array did not reshape. Expected array size: ${expected.getShape().contentToString()} not " +
              "${actual.getShape().contentToString()}"
    assertTrue(expected.getShape().contentEquals(actual.getShape()), failMessage)
    
  }
  
  @Test
  fun plus() {
    val expected = ArrayND(arrayOf(2.0, 4.0, 6.0))
    val actualDouble = ArrayND(arrayOf(1.0, 3.0, 5.0)) + 1.0
    val actualSingle = ArrayND(arrayOf(1.0, 3.0, 5.0)) + ArrayND(arrayOf(1.0))
    val actualVector = ArrayND(arrayOf(1.0, 2.0, 3.0)) + ArrayND(arrayOf(1.0, 2.0, 3.0))
    
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
    val twoDimensionTest = test2D[4, 6].single()
    
    val threeDimensionExpected = 46.0
    val threeDimensionTest = test3D[2, 3, 2].single()
    
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
    val test2 = ArrayND(arrayOf(expectedSingle))
    
    assertEquals(expectedSingle, test2.single())
  }
  
  @Test
  fun getShape1() {
    assertTrue(arrayOf(8, 8).contentEquals(test2D.getShape()))
  }
  
  @Test
  fun minus() {
    val expected = ArrayND(arrayOf(0.0, 0.0, 0.0))
    val actual = ArrayND(arrayOf(1.0, 2.0, 3.0)) - ArrayND(arrayOf(1.0, 2.0, 3.0))
    
    val failMessage = "Expected vector: ${expected.elements.contentToString()} received " +
            "${actual.elements.contentToString()}"
    
    assertTrue(expected.elements.contentEquals(actual.elements)
            && expected.shape.contentEquals(actual.shape), failMessage)
  }
  
  
  @Test
  fun unaryMinus() {
    val expected = ArrayND(arrayOf(2.0, 4.0, 6.0))
    val actual = -ArrayND(arrayOf(-2.0, -4.0, -6.0))
    
    val failMessage = "Expected vector: ${expected.elements.contentToString()} received " +
            "${actual.elements.contentToString()}"
    
    assertTrue(expected.elements.contentEquals(actual.elements)
            && expected.shape.contentEquals(actual.shape), failMessage)
  }
  
  @Test
  fun times() {
    val expected = ArrayND(arrayOf(1.0, 4.0, 9.0))
    val actual = ArrayND(arrayOf(1.0, 2.0, 3.0)) * ArrayND(arrayOf(1.0, 2.0, 3.0))
    
    val failMessage = "Expected vector: ${expected.elements.contentToString()} received " +
            "${actual.elements.contentToString()}"
    
    assertTrue(expected.elements.contentEquals(actual.elements)
            && expected.shape.contentEquals(actual.shape), failMessage)
  }
  
  
  @Test
  fun div() {
    val expected = ArrayND(arrayOf(1.0, 1.0, 1.0))
    val actual = ArrayND(arrayOf(1.0, 2.0, 3.0)) / (ArrayND(arrayOf(1.0, 2.0, 3.0)))
    val failMessage = "Expected vector: ${expected.elements.contentToString()} received " +
            "${actual.elements.contentToString()}"
    assertTrue(expected.elements.contentEquals(actual.elements)
            && expected.shape.contentEquals(actual.shape), failMessage)
  }
  
  
  @Test
  fun equals() {
    val a = ArrayND(arrayOf(0.0, 1.0))
    val b = ArrayND(arrayOf(0.0, 1.0))
    assertTrue(a.equals(b))
  }
  
  @Test
  fun toPolynomial() {
    val expected = ArrayND(arrayOf(17.0))
    var x = ArrayND(arrayOf(1.0, 2.0, 3.0)).toPolynomial()
    val actual = x(2.0)
    val failMessage = "Fail: toPolynomial()" +
            "\nExpected vector: ${expected.elements.contentToString()} received " +
            "${actual.elements.contentToString()}"
    
    assertTrue(expected.equals(actual), failMessage)
    // assertEquals(expected, x(2.0))
  }
  
  @Test
  fun isScalar() {
    val expectedTrue = ArrayND(arrayOf(6.022e23)).isScalar()
    val expectedFalse = ArrayND(arrayOf(1.0, 2.0)).isScalar()
    
    assertEquals(expectedTrue, true)
    assertEquals(expectedFalse, false)
  }
  
  @Test
  fun isVector() {
    val expectedFalse = ArrayND(arrayOf(0.0, 1.0, 2.0, 3.0, 4.0, 5.0)).reshape(2, 3).isVector()
    val expectedTrue = ArrayND(arrayOf(1.0, 2.0)).isVector()
    
    assertEquals(expectedTrue, true)
    assertEquals(expectedFalse, false)
  }
  
  @Test
  fun isEmpty() {
    val expectedFalse1 = ArrayND(arrayOf(6.022e23)).isEmpty()
    val expectedFalse2 = ArrayND(arrayOf(1.0, 2.0)).isEmpty()
    val expectedTrue = ArrayND(arrayOf())
    
    assertTrue(expectedTrue.isEmpty(), "\n\n ${expectedTrue.toString()}")
    assertFalse(expectedFalse1)
    assertFalse(expectedFalse2)
  }
  
}
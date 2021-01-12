import arrayND.ArrayND
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class NumkKtTest {
  
  @Test
  fun aRangeOf() {
    val expected = ArrayND(arrayOf(0.0, 1.0, 2.0, 3.0, 4.0), arrayOf(5))
    val actual = aRangeOf(5)
    
    assertTrue(expected.dataElements.contentEquals(actual.dataElements))
  }
  
  @Test
  fun arrayNDOf() {
  }
  
  @Test
  fun testArrayNDOf() {
  }
  
  @Test
  fun linspace() {
  }
  
  @Test
  fun zeros() {
  }
}
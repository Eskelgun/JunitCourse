package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BusinessTest {

  @Test
  void calculateSumSuccessfulResponse() {
//    ARRANGE
    BusinessImpl business = new BusinessImpl();
    int expectedResult = 6;

//    ACT
    int actualResult = business.calculateSum(new int[]{1, 2, 3});

//    ASSERT
    assertEquals(expectedResult, actualResult);
  }

  @Test
  void calculateSumSuccessfulResponseOneNumberValue() {
//    ARRANGE
    BusinessImpl business = new BusinessImpl();
    int expectedResult = 3;

//    ACT
    int actualResult = business.calculateSum(new int[]{3});

//    ASSERT
    assertEquals(expectedResult, actualResult);
  }

  @Test
  void calculateSumEmptySum() {
//    ARRANGE
    BusinessImpl business = new BusinessImpl();
    int expectedResult = 0;

//    ACT
    int actualResult = business.calculateSum(new int[]{});

//    ASSERT
    assertEquals(expectedResult, actualResult);
  }





}
package business;

import data.DataRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/*
Se hace enfacis en lo ineficiente que puede llegar a ser
testear clases haciendo stubbing o codigo stub
*/

class DataRepositoryStub implements DataRepository {

  @Override
  public int[] getAllNumbersData() {
    return new int[]{1, 2, 3};
  }
}

class DataRepositoryNoValuesStub implements DataRepository {

  @Override
  public int[] getAllNumbersData() {
    return new int[]{};
  }
}

class DataRepositoryOneValueStub implements DataRepository {

  @Override
  public int[] getAllNumbersData() {
    return new int[]{3};
  }
}

class BusinessStubTest {

  private BusinessImpl business;
  private DataRepositoryStub dataRepositoryStub;
  private DataRepositoryNoValuesStub dataRepositoryNoValuesStub;
  private DataRepositoryOneValueStub dataRepositoryOneValueStub;

  public BusinessStubTest() {
    business = new BusinessImpl();
    dataRepositoryStub = new DataRepositoryStub();
    dataRepositoryNoValuesStub = new DataRepositoryNoValuesStub();
    dataRepositoryOneValueStub = new DataRepositoryOneValueStub();
  }

  @Test
  void calculateSumSuccessfulResponse() {
//    ARRANGE
    business.setDataRepository(dataRepositoryStub);
    int expectedResult = 6;

//    ACT
    int actualResult = business.calculateSumUsingDataReposiroty();

//    ASSERT
    assertEquals(expectedResult, actualResult);
  }

  @Test
  void calculateSumSuccessfulResponseOneNumberValue() {
//    ARRANGE
    business.setDataRepository(dataRepositoryOneValueStub);
    int expectedResult = 3;

//    ACT
    int actualResult = business.calculateSumUsingDataReposiroty();

//    ASSERT
    assertEquals(expectedResult, actualResult);
  }

  @Test
  void calculateSumEmptySum() {
//    ARRANGE
    business.setDataRepository(dataRepositoryNoValuesStub);
    int expectedResult = 0;

//    ACT
    int actualResult = business.calculateSumUsingDataReposiroty();

//    ASSERT
    assertEquals(expectedResult, actualResult);
  }


}
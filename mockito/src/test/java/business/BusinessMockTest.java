package business;

import data.DataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BusinessMockTest {

/*
La etiqueta @ExtendWith(MockitoExtension.class) se encargaría
de trabajar con JUnit5 y por consecuente de la instancia de las clases y/o dependencias
*/
  @InjectMocks
  private BusinessImpl business;
  @Mock
  private DataRepository dataRepositoryMock;

//  public BusinessMockTest() {
//    business = new BusinessImpl();
//    dataRepositoryMock = mock(DataRepository.class);
//
//  }


/*
Mockito realizaria la inyección de dependencias gracias a la etiqueta
@InjectMocks y @Mock, por ende ya no necesitariamos el metodo del @BeforeEach
*/

//  @BeforeEach
//  public void BeforeEach() {
//    business.setDataRepository(dataRepositoryMock);
//  }

  @Test
  void calculateSumSuccessfulResponse() {
//    ARRANGE
    when(dataRepositoryMock.getAllNumbersData()).thenReturn(new int[]{1, 2, 3});
    int expectedResult = 6;

//    ACT
    int actualResult = business.calculateSumUsingDataReposiroty();

//    ASSERT
    assertEquals(expectedResult, actualResult);
  }

  @Test
  void calculateSumSuccessfulResponseOneNumberValue() {
//    ARRANGE
    when(dataRepositoryMock.getAllNumbersData()).thenReturn(new int[]{3});
    int expectedResult = 3;

//    ACT
    int actualResult = business.calculateSumUsingDataReposiroty();

//    ASSERT
    assertEquals(expectedResult, actualResult);
  }

  @Test
  void calculateSumEmptySum() {
//    ARRANGE
    when(dataRepositoryMock.getAllNumbersData()).thenReturn(new int[]{});
    int expectedResult = 0;

//    ACT
    int actualResult = business.calculateSumUsingDataReposiroty();

//    ASSERT
    assertEquals(expectedResult, actualResult);
  }


}
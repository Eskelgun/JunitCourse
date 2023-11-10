import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ListMockTest {

  List<String> listMock = mock(List.class);

  @Test
  void basicTest() {
    when(listMock.size()).thenReturn(5);

    assertEquals(5, listMock.size());
  }

  @Test
  void returnDifferentValues() {

    when(listMock.size()).thenReturn(5).thenReturn(8);

    assertEquals(5, listMock.size());
    assertEquals(8, listMock.size());
  }

  /*
  Cuando mockeamos listMock.get(0) siempre nos devolverá "abc"
  en dado caso de ejecutar listMock.get(1) u otro valor diferente
  el metodo nos devolverá el valor por defecto del return que le corresponde
  boolean -> false, Objetcs -> null, Collections -> empty collection... etc
  */
  @Test
  void returnMethodsWithParameters() {
    when(listMock.get(0)).thenReturn("abc");
    assertEquals("abc", listMock.get(0));
    assertEquals(null, listMock.get(1));
  }

  @Test
  void returnMethodsWithGenericParameters() {
    when(listMock.get(anyInt())).thenReturn("abc");
    assertEquals("abc", listMock.get(0));
    assertEquals("abc", listMock.get(1));
  }

  /*
  Metodo verify
  */
  @Test
  void verificationBasics() {

    String value = listMock.get(0);
    String value2 = listMock.get(1);

//    Verify
    verify(listMock).get(0);

    /*Utitilizando anyInt() sólo lo verifica una vez, podriamos usar times() o atLeast()*/
//    verify(listMock).get(anyInt());
    verify(listMock, times(2)).get(anyInt());
    verify(listMock, atLeast(1)).get(anyInt());

    verify(listMock, atMost(2)).get(anyInt());
    verify(listMock, never()).get(5);
    verify(listMock, never()).size();
  }

}

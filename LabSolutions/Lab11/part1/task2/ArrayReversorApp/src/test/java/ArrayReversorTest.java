import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayReversorTest {

    @Test
    public void testReverseArrayWithLegitInput() {
        ArrayFlattenerService serviceMock = Mockito.mock(ArrayFlattenerService.class);
        Mockito.when(serviceMock.flattenArray(Mockito.argThat(array -> Arrays.deepEquals(array, new Integer[][]{{1, 3}, {0}, {4, 5, 9}}))))
                .thenReturn(new Integer[]{1, 3, 0, 4, 5, 9});


        ArrayReversor reversor = new ArrayReversor(serviceMock);
        Integer[] result = reversor.reverseArray(new Integer[][]{{1, 3}, {0}, {4, 5, 9}});
        Assertions.assertArrayEquals(new Integer[]{9, 5, 4, 0, 3, 1}, result);

        //Mockito.verify(serviceMock).flattenArray(new Integer[][]{{1, 3}, {0}, {4, 5, 9}});
    }

    @Test
    public void testReverseArrayWithNullInput() {
        ArrayFlattenerService serviceMock = Mockito.mock(ArrayFlattenerService.class);
        Mockito.when(serviceMock.flattenArray(null)).thenReturn(null);

        ArrayReversor reversor = new ArrayReversor(serviceMock);
        Integer[] result = reversor.reverseArray(null);
        Assertions.assertNull(result);

        Mockito.verify(serviceMock).flattenArray(null);
    }
}
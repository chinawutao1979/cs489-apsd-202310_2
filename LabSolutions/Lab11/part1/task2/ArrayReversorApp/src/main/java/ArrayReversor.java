import java.util.Collections;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class ArrayReversor {
    private ArrayFlattenerService arrayFlattenerService;

    public ArrayReversor(ArrayFlattenerService arrayFlattenerService) {
        this.arrayFlattenerService = arrayFlattenerService;
    }

    public Integer[] reverseArray(Integer[][] inputArray) {
        Integer[] flattenedArray = arrayFlattenerService.flattenArray(inputArray);
        if (flattenedArray == null) {
            return null;
        }
        List<Integer> list = Arrays.asList(flattenedArray);
        Collections.reverse(list);
        return list.toArray(new Integer[0]);
    }
}


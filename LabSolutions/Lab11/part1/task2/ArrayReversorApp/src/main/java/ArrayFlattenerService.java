import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayFlattenerService {
    public Integer[] flattenArray(Integer[][] twoDArray) {
        if (twoDArray == null) {
            return null;
        }

        List<Integer> flattenedList = new ArrayList<>();

        for (Integer[] innerArray : twoDArray) {
            flattenedList.addAll(Arrays.asList(innerArray));
        }

        return flattenedList.toArray(new Integer[0]);
    }
}

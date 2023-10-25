import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Assertions;


public class ArrayFlattenerTest {

    @Test
   public void testFlattenArrayWithLegitInput() {
        Integer[][] input = {{1, 3}, {0}, {4, 5, 9}};
        Integer[] expected = {1, 3, 0, 4, 5, 9};
        Integer[] actual = ArrayFlattener.flattenArray(input);
        MatcherAssert.assertThat("Test fails: Result does not match",
                actual, CoreMatchers.is(CoreMatchers.equalTo(expected)));
    }

    @Test
   public void testFlattenArrayWithNullInput() {
        Integer[][] input = null;
        Integer[] result = ArrayFlattener.flattenArray(input);
        MatcherAssert.assertThat(result, Matchers.nullValue());
    }
}

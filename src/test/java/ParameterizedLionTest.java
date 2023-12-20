import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ParameterizedLionTest {

    private final String sex;
    private final int expectedKittens;
    private final boolean expectedHasMane;
    private final List<String> expectedFood;
    private final boolean expectException;

    public ParameterizedLionTest(String sex, int expectedKittens, boolean expectedHasMane, List<String> expectedFood, boolean expectException) {
        this.sex = sex;
        this.expectedKittens = expectedKittens;
        this.expectedHasMane = expectedHasMane;
        this.expectedFood = expectedFood;
        this.expectException = expectException;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", 3, true, List.of("Мясо"), false},
                {"сОмец", 0, false, List.of(), true}
                // Add more test cases as needed
        });
    }

    @Test
    public void testGetKittens() {
        try {
            Feline mockFeline = Mockito.mock(Feline.class);
            Mockito.when(mockFeline.getKittens()).thenReturn(3);

            Lion lion = new Lion(sex, mockFeline);
            int kittens = lion.getKittens();

            assertEquals(expectedKittens, kittens);
        } catch (Exception e) {
            assertEquals(expectException, true);
        }
    }

    @Test
    public void testDoesHaveMane() {
        try {
            Feline mockFeline = Mockito.mock(Feline.class);

            Lion lion = new Lion(sex, mockFeline);
            boolean hasMane = lion.doesHaveMane();

            assertEquals(expectedHasMane, hasMane);
        } catch (Exception e) {
            assertEquals(expectException, true);
        }
    }

    @Test
    public void testGetFood() {
        try {
            Feline mockFeline = Mockito.mock(Feline.class);
            Mockito.when(mockFeline.getFood("Хищник")).thenReturn(List.of("Мясо"));

            Lion lion = new Lion(sex, mockFeline);
            List<String> food = lion.getFood();

            assertEquals(expectedFood, food);
        } catch (Exception e) {
            assertEquals(expectException, true);
        }
    }
}
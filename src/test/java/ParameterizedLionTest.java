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

@RunWith(Parameterized.class)
public class ParameterizedLionTest {

    private final String sex;
    private final int expectedKittens;
    private final List<String> expectedFood;
    private final boolean expectException;

    public ParameterizedLionTest(String sex, int expectedKittens, List<String> expectedFood, boolean expectException) {
        this.sex = sex;
        this.expectedKittens = expectedKittens;
        this.expectedFood = expectedFood;
        this.expectException = expectException;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", 3, List.of("Мясо"), false},
                {"Самка", 3, List.of("Мясо"), false}
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
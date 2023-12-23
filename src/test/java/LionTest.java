import static org.junit.Assert.*;

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;

public class LionTest {

    @Test
    public void testGetKittens() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Mockito.when(mockFeline.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", mockFeline);
        int kittens = lion.getKittens();

        assertEquals(3, kittens);
    }

    @Test
    public void testDoesHaveMane() throws Exception {

        Lion maleLion = new Lion("Самец", new Feline());
        assertLionHasMane(maleLion);

        Lion femaleLion = new Lion("Самка", new Feline());
        assertLionDoesNotHaveMane(femaleLion);
    }

    private void assertLionHasMane(Lion lion) {
        assertTrue(lion.doesHaveMane());
    }

    private void assertLionDoesNotHaveMane(Lion lion) {
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testGetFood() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Mockito.when(mockFeline.getFood("Хищник")).thenReturn(List.of("Мясо"));

        Lion lion = new Lion("Самец", mockFeline);
        List<String> food = lion.getFood();

        assertEquals(List.of("Мясо"), food);
    }

    @Test(expected = Exception.class)
    public void testInvalidSex() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);

        new Lion("InvalidSex", mockFeline);
    }
}
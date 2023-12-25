import static org.junit.Assert.*;

import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;

public class CatTest {

    @Test
    public void testGetSound() {
        Cat cat = new Cat(new Feline());
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Mockito.when(mockFeline.eatMeat()).thenReturn(List.of("Мясо"));

        Cat cat = new Cat(mockFeline);
        List<String> food = cat.getFood();

        assertEquals(List.of("Мясо"), food);
    }

    @Test
    public void testGetFamily() {
        Feline mockFeline = Mockito.mock(Feline.class);
        Mockito.when(mockFeline.getFamily()).thenReturn("Тестовые кошачьи");

        Cat cat = new Cat(mockFeline);
        String family = cat.getFamily();

        assertEquals("Тестовые кошачьи", family);
    }
}

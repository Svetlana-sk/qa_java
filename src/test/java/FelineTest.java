import com.example.Feline;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    @Test
    public void testEatMeat() {
        Feline feline = new Feline();
        try {
            List<String> food = feline.eatMeat();
            assertNotNull(food);
            assertFalse(food.isEmpty());
            assertTrue(food.contains("Животные"));
            assertTrue(food.contains("Птицы"));
            assertTrue(food.contains("Рыба"));
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithCount() {
        Feline feline = new Feline();
        int kittensCount = 3;
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}

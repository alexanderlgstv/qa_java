import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test()
    public void getLionGenderExceptionTest() {
        Exception actualException = assertThrows(Exception.class, () ->
                new Lion("example", feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", actualException.getMessage());
    }

    @Test
    public void doesHaveMane() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean expectedHaveMane = true;
        boolean actualHaveMane = lion.doesHaveMane();
        assertEquals(expectedHaveMane, actualHaveMane);
    }

    @Test
    public void getKittensPositiveResult() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void getLionEatsAnotherMeat() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Рыба", "Птицы"));
        List<String> expectedEatLionMeat = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualEatLionMeat = lion.getFood();
        assertTrue(expectedEatLionMeat.size() == actualEatLionMeat.size() && expectedEatLionMeat.containsAll(actualEatLionMeat) && actualEatLionMeat.containsAll(expectedEatLionMeat));
    }

    @Test
    public void getLionEatsMeatTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> expectedEatLionMeat = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualEatLionMeat = lion.getFood();
        assertEquals(expectedEatLionMeat, actualEatLionMeat);
    }
}

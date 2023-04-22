import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
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
    public void getLionGenderException() throws Exception {
        try {
            Lion lion = new Lion(" ", feline);
            lion.doesHaveMane();
        } catch (Exception thrown) {
            assertNotEquals(" ", thrown.getMessage());
        }
    }

    @Test()
    public void incorrectGenderReturnExceptionText() throws Exception {
        String sex = "example";
        try {
            Lion lion = new Lion(sex, feline);
            Assert.fail("Exception thrown");
        } catch (Exception thrown) {
            assertNotEquals(sex, thrown.getMessage());
        }
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

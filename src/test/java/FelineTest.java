import com.example.Feline;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class FelineTest {

    @Test
    public void getFelineFoodTest() throws Exception {
        Feline feline = new Feline();
        List<String> actualAnimalFoodList = feline.eatMeat();
        List<String> expectedAnimalList = Arrays.asList("Животные", "Птицы", "Рыба");
        assertEquals(expectedAnimalList, actualAnimalFoodList);
    }

    @Test
    public void getFelineFamilyTest() {
        Feline feline = new Feline();
        String actualFamily = feline.getFamily();
        assertEquals("Кошачьи", actualFamily);
    }

    @Test
    public void getFelineCountKittensTest() {
        Feline feline = new Feline();
        int actualKittens = feline.getKittens();
        assertEquals(1, actualKittens);
    }
}

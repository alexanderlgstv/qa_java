import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;

    @Test
    public void getCatSoundReturnMeow() {
        Cat cat = new Cat(feline);
        String expectedCatSound = "Мяу";
        String actualGetSound = cat.getSound();
        Assert.assertEquals("Кот издал не Мяу", expectedCatSound, actualGetSound);
    }

    @Test
    public void getFoodMethodTest() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualFood = cat.getFood();
        Assert.assertEquals("Еда не соответствует виду животного", expectedFood, actualFood);
    }

    @Test
    public void getCatFoodMockTest() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(Arrays.asList("Фарш", "Стейк", "Гуляш"));
        Assert.assertEquals(Arrays.asList("Фарш", "Стейк", "Гуляш"), cat.getFood());
    }
}

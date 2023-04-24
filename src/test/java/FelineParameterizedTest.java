import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {
    private final int kittensCount;

    public FelineParameterizedTest(int kittensCount) {
        this.kittensCount = kittensCount;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] getKittens() {
        return new Object[][]{
                {8},
                {2},
                {-3},
                {-8},
        };
    }

    @Test
    public void kittensCountReturn() {
        Feline feline = new Feline();
        int actual = feline.getKittens(kittensCount);
        assertEquals("Количество не соответствует", kittensCount, actual);
    }
}

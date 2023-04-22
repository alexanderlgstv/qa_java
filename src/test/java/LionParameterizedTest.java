import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private final String lionSex;
    private final boolean hasMane;


    public LionParameterizedTest(String lionSex, boolean hasMane) {
        this.lionSex = lionSex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getSexData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void hasMane() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(lionSex, feline);
        boolean actual = lion.doesHaveMane();
        assertEquals("Неправильное значение в hasMane", hasMane, actual);
    }
}

import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AnimalTest {

    @Test()
    public void getAnimalFoodReturnException() throws Exception {
        Animal animal = new Animal();
        String actualAnimalFoodRequest = "lol";
        try {
            animal.getFood(actualAnimalFoodRequest);
            Assert.fail("Exception thrown");
        } catch (Exception thrown) {
            assertNotEquals(actualAnimalFoodRequest, thrown.getMessage());
        }
    }

    @Test
    public void getAnimalFamilyReturnValue() {
        Animal animal = new Animal();
        String actualAnimalFamily = animal.getFamily();
        String expectedAnimalFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expectedAnimalFamily, actualAnimalFamily);
    }

    @Test
    public void getFoodValueReturn() throws Exception {
        Animal animal = new Animal();
        List<String> expectedFood = List.of("Трава", "Различные растения");
        List<String> actualFood = animal.getFood("Травоядное");
        assertEquals(expectedFood, actualFood);
    }

}

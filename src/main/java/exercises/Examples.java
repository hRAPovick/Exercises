package exercises;

import org.junit.Test;
import java.util.Random;

public class Examples {
    /**
     * Метод для поиска суммы из 100 случайных значений от 0 до 100,
     * которые делятся без остатка на 7 или 9
     */
    @Test
    public void divisionByNine() {
        int sum = new Random()
                .ints(100, 0, 100)
                .filter(x -> (x % 7 == 0) || (x % 9 == 0))
                .sum();
        System.out.println(sum);
    }

}

package exercises.companes.util;

import exercises.companes.domain.Worker;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static exercises.enums.LastName.getRandomLastName;
import static exercises.enums.Name.getRandomName;
import static exercises.enums.Profession.getRandomProfession;

public class WorkerCreator {
    private static final int MIN_SALARY = 30_000;
    private static final int MAX_SALARY = 100_000;

    @Test
    public void differentWorkersTest(){
        for (int i = 0; i < 4; i++) {
            System.out.println(workerCreator());
        }
    }

    /**
     * @return Worker со случайными атрибутами:
     * имя: Enum<Name>,
     * фамилия: Enum<LastName>,
     * профессия: Enum<Professions>,
     * зарплата: от 30_000 до 100_000.
     */
    public Worker workerCreator() {
        return new Worker(getRandomName(), getRandomLastName(), getRandomProfession(),
                ThreadLocalRandom.current().nextInt(MIN_SALARY, MAX_SALARY));
    }

    /**
     * Метод для получения списка сгенерированных работников
     * @param number - необходимое количество работников
     * @return - список работников
     */
    public List<Worker> getWorkers(int number) {
        List<Worker> list = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            list.add(workerCreator());
        }
        return list;
    }
}

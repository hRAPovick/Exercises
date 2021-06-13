package stream.companes.util;

import stream.companes.domain.Worker;
import stream.companes.enums.LastName;
import stream.companes.enums.Name;
import stream.companes.enums.Profession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class WorkerCreator {
    private static final int NAMES_AMOUNT = Name.values().length;
    private static final int LAST_NAMES_AMOUNT = LastName.values().length;
    private static final int PROFESSIONS_AMOUNT = Profession.values().length;
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
        return new Worker(
                Name.values()[ThreadLocalRandom.current()
                        .nextInt(NAMES_AMOUNT)],
                LastName.values()[ThreadLocalRandom.current()
                        .nextInt(LAST_NAMES_AMOUNT)],
                Profession.values()[ThreadLocalRandom.current()
                        .nextInt(PROFESSIONS_AMOUNT)],
                ThreadLocalRandom.current()
                        .nextInt(MIN_SALARY, MAX_SALARY));
    }

    /**
     * Метод для получения списка сгенерированных работников
     * @param number - необходимое колличество работников
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

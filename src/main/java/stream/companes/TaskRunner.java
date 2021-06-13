package stream.companes;

import stream.companes.domain.Company;
import stream.companes.domain.Worker;
import stream.companes.enums.Brand;
import stream.companes.enums.Profession;
import stream.companes.util.CompanyCreator;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class TaskRunner {
    private static final int FIVE = 5;
    private static final int FORTY = 40;
    private static final int PROFESSION_AMOUNT = Profession.values().length;
    private final CompanyCreator organizationCreator = new CompanyCreator();
    private final List<Company> companies = organizationCreator.listOfCompaniesCreator(FORTY);

    /**
     * Метод создает из листа компаний стрим всех работников этих компаний.
     * Затем считает сколько человек занимает одинаковые должности.
     */
    @Test
    public void groupCountByProfession() {
        Map<Enum<Profession>, Long> workersByProf = companies.stream()
                .flatMap(company -> company.getWorkers().stream())
                .collect(Collectors.groupingBy(Worker::getProfession, Collectors.counting()));

        System.out.println("How many workers have similar profession: \n");
        for (Map.Entry<Enum<Profession>, Long> element: workersByProf.entrySet()) {
            System.out.println("Profession: " + element.getKey() + "\n Worker(s) = " + element.getValue().toString());
            System.out.println();
        }
    }

    /**
     * Метод определяет какие специальности есть в каждой компании.
     */
    @Test
    public void allProfessionInCompanies() {
        TreeMap<Enum<Brand>, List<Enum<Profession>>> map = companies.stream()
                .filter(company -> company.getWorkers().size() > FIVE)
                .collect(Collectors.toMap(
                        Company::getOrganisationName,
                        company -> company.getWorkers().stream()
                                .map(Worker::getProfession)
                                .distinct()
                                .collect(Collectors.toList()),
                        (oldValue, newValue) -> newValue,
                        TreeMap::new));

        System.out.println("List of all professions in each companies: \n");
        for (Map.Entry<Enum<Brand>, List<Enum<Profession>>> element: map.entrySet()) {
            System.out.println("Organisation Name: " + element.getKey().toString() + "\nAll workers professions: " + element.getValue());
            System.out.println();
        }
    }

    /**
     * Метод вычисляет среднюю зарплату в компаниях, где колличество рабоников больше 5 человек.
     * Выводит список компаний на экран по возрастанию средней зарплаты.
     */
    @Test
    public void avgSalaryInCompanies() {
        SortedMap<Double, Enum<Brand>> sortedMap = companies.stream()
                .filter(company -> company.getWorkers().size() > FIVE)
                .collect(Collectors.toMap(
                        company -> company.getWorkers().stream().collect(Collectors.averagingInt(Worker::getSalary)),
                        Company::getOrganisationName,
                        (oldValue, newValue) -> oldValue,
                        TreeMap::new));

        System.out.println("Average salary in different companies: \n");
        for (Map.Entry<Double, Enum<Brand>> element: sortedMap.entrySet()) {
            System.out.println("Organisation Name: " + element.getValue().toString() + "\naveraging salary: " + element.getKey());
            System.out.println();
        }
    }

    /**
     * Метод возвращает имена сотрудников из всех компаний, которые работают на заданной должности,
     * отсортировав их по зарплате.
     */
    @Test
    public void sortBySalaryOnOneProfession() {
        Enum<Profession> randomProfession = Profession.values()
                [ThreadLocalRandom.current().nextInt(PROFESSION_AMOUNT)];

        List<Worker> workers = companies.stream()
                .flatMap(company -> company.getWorkers().stream())
                .filter(worker -> worker.getProfession().equals(randomProfession))
                .sorted((o1, o2) -> Integer.compare(o1.getSalary(), o2.getSalary()))
                .collect(Collectors.toList());

        System.out.println("List of one-profession-workers in all companies which sorted by salary.");
        System.out.println("Profession: " + randomProfession + "\nWorkers:\n");
        System.out.println(workers);
    }



}

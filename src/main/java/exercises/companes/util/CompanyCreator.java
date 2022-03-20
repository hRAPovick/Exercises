package exercises.companes.util;

import exercises.companes.domain.Company;
import exercises.companes.domain.Worker;
import exercises.enums.Brand;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import static exercises.enums.Brand.getRandomBrand;

public class CompanyCreator {
    private static final int MIN_WORKERS = 3;
    private static final int MAX_WORKERS = 20;
    private final WorkerCreator workerCreator = new WorkerCreator();

    @Test
    public void differentCompaniesTest(){
        for (int i = 0; i < 4; i++) {
            System.out.println(companyCreator());
        }
    }

    /**
     * Метод для получения список компаний.
     * @param numberOfCompanies - необходимое колличество компаний.
     * @return список компаний.
     */
    public List<Company> listOfCompaniesCreator(int numberOfCompanies) {
        List<Company> companyList = new ArrayList<>();
        Company company;
        Set<Enum<Brand>> companyNames = new HashSet<>();
        for (int i = 0; i < numberOfCompanies; i++) {
            while (true) {
                company = companyCreator();
                if (!companyNames.contains(company.getOrganisationName())) {
                    companyNames.add(company.getOrganisationName());
                    break;
                }
            }
            companyList.add(company);
        }
        return companyList;
    }

    /**
     * @return Organization со случайным количеством работников от MIN_WORKERS до MAX_WORKERS,
     * случайным id из java.util.UUID и случайным именем из Enum<Brand>.
     */
    public Company companyCreator() {
        int numberOfWorkers = ThreadLocalRandom.current()
                .nextInt(MIN_WORKERS, MAX_WORKERS);
        List<Worker> workers = workerCreator.getWorkers(numberOfWorkers);

        return new Company(
                UUID.randomUUID(),
                workers,
                getRandomBrand()
        );
    }
}

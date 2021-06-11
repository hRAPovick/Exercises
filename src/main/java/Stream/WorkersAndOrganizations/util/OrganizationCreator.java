package Stream.WorkersAndOrganizations.util;

import Stream.WorkersAndOrganizations.domain.Organization;
import Stream.WorkersAndOrganizations.domain.Worker;
import Stream.WorkersAndOrganizations.enums.Name;
import Stream.WorkersAndOrganizations.enums.OrganisationName;
import Stream.WorkersAndOrganizations.enums.Professions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class OrganizationCreator {
    private final int NUMBER_OF_NAMES = Name.values().length;
    private final int NUMBER_OF_PROF = Professions.values().length;
    private final int NUMBER_OF_ORG_NAMES = OrganisationName.values().length;
    private final int NUMBER_OF_ORGS = 5;
    private final int MIN_SALARY = 30_000;
    private final int MAX_SALARY = 100_000;
    private final int MIN_WORKERS = 3;
    private final int MAX_WORKERS = 10;

    @Test
    public void test() {
        System.out.println(workerCreator());
        System.out.println();
        System.out.println(organizationCreator());
        System.out.println(organizationsListCreator(NUMBER_OF_ORGS));
    }

    /**
     * @return Список Организаций.
     */
    public List<Organization> organizationsListCreator(int numberOfOrgs) {
        List<Organization> organizationList = new ArrayList<>();
        Organization organization = null;
        for (int i = 0; i < numberOfOrgs; i++) {
            Organization finalOrganization = organization;
            do {
                organization = organizationCreator();
            } while (!organizationList.stream().anyMatch(name -> name.getOrganisationName().equals(finalOrganization.getOrganisationName())));
            organizationList.add(organization);
        }

        return organizationList;
    }

    /**
     * @return Organization со случайным количеством работников от 3 до 10,
     * случайным id из java.util.UUID и случайным именем из Enum OrganizationName.
     */
    public Organization organizationCreator() {
        int numberOfWorkers = ThreadLocalRandom.current()
                .nextInt(MIN_WORKERS, MAX_WORKERS);
        List<Worker> workers = new ArrayList<>();

        for (int i = 0; i <= numberOfWorkers; i++) {
            workers.add(workerCreator());
        }

        return new Organization(
                UUID.randomUUID(),
                workers,
                OrganisationName.values()[ThreadLocalRandom.current()
                        .nextInt(NUMBER_OF_ORG_NAMES)]
                );
    }

    /**
     * @return Worker со случайным именем из Enum Name, случайной
     *     профессией из Enum Professions, и зарплатой до 100_000.
     */
    public Worker workerCreator() {
        return new Worker(
                Name.values()[ThreadLocalRandom.current()
                        .nextInt(NUMBER_OF_NAMES)],
                Professions.values()[ThreadLocalRandom.current()
                        .nextInt(NUMBER_OF_PROF)],
                ThreadLocalRandom.current()
                        .nextInt(MIN_SALARY, MAX_SALARY));
    }
}

package Stream.WorkersAndOrganizations;

import Stream.WorkersAndOrganizations.domain.Organization;
import Stream.WorkersAndOrganizations.domain.Worker;
import Stream.WorkersAndOrganizations.enums.OrganisationName;
import Stream.WorkersAndOrganizations.enums.Professions;
import Stream.WorkersAndOrganizations.util.OrganizationCreator;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class TaskRunner {
    private final int FIVE_ORGS = 5;
    private final int TEN_ORGS = 10;
    /**
     * Метод создает стрим из работников (.flatMap) и затем группирует их в мапу по профессии:
     * Ключ: профессия, Значение: Set работников.
     */
    @Test
    public void groupWorkersByProfession() {
        OrganizationCreator organizationCreator = new OrganizationCreator();
        List<Organization> organizations = organizationCreator.organizationsListCreator(FIVE_ORGS);

        Map<Enum<Professions>, Set<Worker>> workersByProf = organizations.stream()
                .flatMap(organization -> organization.getWorkers().stream())
                .collect(Collectors.groupingBy(Worker::getProfessionsEnum, Collectors.toSet()));

        for (Map.Entry<Enum<Professions>, Set<Worker>> element: workersByProf.entrySet()) {
            System.out.println("Profession: " + element.getKey() + "\n Worker(s) = " + element.getValue().toString());
            System.out.println();
        }
    }

    /**
     * Метод создает стрим из работников (.flatMap) и затем группирует их в мапу по профессии:
     * Ключ: профессия, Значение: количество работников.
     */
    @Test
    public void groupCountByProfession() {
        OrganizationCreator organizationCreator = new OrganizationCreator();
        List<Organization> organizations = organizationCreator.organizationsListCreator(FIVE_ORGS);

        Map<Enum<Professions>, Long> workersByProf = organizations.stream()
                .flatMap(organization -> organization.getWorkers().stream())
                .collect(Collectors.groupingBy(Worker::getProfessionsEnum, Collectors.counting()));

        for (Map.Entry<Enum<Professions>, Long> element: workersByProf.entrySet()) {
            System.out.println("Profession: " + element.getKey() + "\n Worker(s) = " + element.getValue().toString());
            System.out.println();
        }
    }

    /**
     * Метод создает стрим из работников (.flatMap) и затем группирует их в мапу по профессии:
     * Ключ: профессия, Значение: количество работников.
     */
    @Test
    public void avgSalaryInMoreThenFiveWorkersOrgs() {
        OrganizationCreator organizationCreator = new OrganizationCreator();
        List<Organization> organizations = organizationCreator.organizationsListCreator(TEN_ORGS);

        List<Double> list = organizations.stream()
                .filter(organization -> organization.getWorkers().size() > 5)
                .map(organization -> organization.getWorkers().stream().map(Worker::getSalary).collect(Collectors.averagingDouble(Integer::doubleValue)))
                .collect(Collectors.toList());
        System.out.println(list);
    }


    /**
     * Метод создает стрим из работников (.flatMap) и затем группирует их в мапу по профессии:
     * Ключ: профессия, Значение: количество работников.
     */
    @Test
    public void avgSalaryInMoreThenFiveWorkersOrgsWithNames() {
        OrganizationCreator organizationCreator = new OrganizationCreator();
        List<Organization> organizations = organizationCreator.organizationsListCreator(TEN_ORGS);

        Map<Enum<OrganisationName>, Double> map = organizations.stream()
                .filter(organization -> organization.getWorkers().size() > 5)
                .collect(Collectors.toMap(
                        Organization::getOrganisationName,
                        organization -> organization.getWorkers().stream().map(Worker::getSalary).collect(Collectors.averagingDouble(Integer::doubleValue))));

        for (Map.Entry<Enum<OrganisationName>, Double> element: map.entrySet()) {
            System.out.println("Organisation Name: " + element.getKey() + "\n averaging salary = " + element.getValue().toString());
            System.out.println();
        }
    }
}

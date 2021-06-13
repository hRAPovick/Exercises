package stream.companes.domain;

import stream.companes.enums.Brand;

import java.util.List;
import java.util.UUID;

public class Company {
    private UUID id;
    private List<Worker> workers;
    private Enum<Brand> organisationName;

    public Company(UUID id, List<Worker> workers, Enum<Brand> organisationName) {
        this.id = id;
        this.workers = workers;
        this.organisationName = organisationName;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", workers=" + workers +
                ", organisationName=" + organisationName +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public Enum<Brand> getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(Enum<Brand> organisationName) {
        this.organisationName = organisationName;
    }
}

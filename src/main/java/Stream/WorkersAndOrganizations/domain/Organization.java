package Stream.WorkersAndOrganizations.domain;

import Stream.WorkersAndOrganizations.enums.OrganisationName;

import java.util.List;
import java.util.UUID;

public class Organization {
    private UUID id;
    private List<Worker> workers;
    private Enum<OrganisationName> organisationName;

    public Organization(UUID id, List<Stream.WorkersAndOrganizations.domain.Worker> workers, Enum<OrganisationName> organisationName) {
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

    public List<Stream.WorkersAndOrganizations.domain.Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Stream.WorkersAndOrganizations.domain.Worker> workers) {
        this.workers = workers;
    }

    public Enum<OrganisationName> getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(Enum<OrganisationName> organisationName) {
        this.organisationName = organisationName;
    }
}

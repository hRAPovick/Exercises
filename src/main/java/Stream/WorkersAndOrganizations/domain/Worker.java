package Stream.WorkersAndOrganizations.domain;

import Stream.WorkersAndOrganizations.enums.Name;
import Stream.WorkersAndOrganizations.enums.Professions;

public class Worker {
    private Enum<Name> name;
    private Enum<Professions> professionsEnum;
    private int salary;

    public Worker(Enum<Name> name, Enum<Professions> professionsEnum, int salary) {
        this.name = name;
        this.professionsEnum = professionsEnum;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Worker:\n" +
                "name=" + name +
                ", professionsEnum=" + professionsEnum +
                ", salary=" + salary + "\n";
    }

    public Enum<Name> getName() {
        return name;
    }

    public void setName(Enum<Name> name) {
        this.name = name;
    }

    public Enum<Professions> getProfessionsEnum() {
        return professionsEnum;
    }

    public void setProfessionsEnum(Enum<Professions> professionsEnum) {
        this.professionsEnum = professionsEnum;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

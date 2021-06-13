package stream.companes.domain;

import stream.companes.enums.LastName;
import stream.companes.enums.Profession;
import stream.companes.enums.Name;

public class Worker {
    private Enum<Name> name;
    private Enum<LastName> lastName;
    private Enum<Profession> profession;
    private int salary;

    public Worker(Enum<Name> name, Enum<LastName> lastName, Enum<Profession> profession, int salary) {
        this.name = name;
        this.lastName = lastName;
        this.profession = profession;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\n" + name + " " + lastName +
                "\n profession: " + profession +
                "\n salary:" + salary + "\n";
    }

    public Enum<Name> getName() {
        return name;
    }

    public void setName(Enum<Name> name) {
        this.name = name;
    }

    public Enum<LastName> getLastName() {
        return lastName;
    }

    public void setLastName(Enum<LastName> lastName) {
        this.lastName = lastName;
    }

    public Enum<Profession> getProfession() {
        return profession;
    }

    public void setProfession(Enum<Profession> profession) {
        this.profession = profession;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

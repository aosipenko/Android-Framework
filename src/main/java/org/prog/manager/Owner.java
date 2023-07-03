package org.prog.manager;

public class Owner {
    private final String name;
    private final String lastName;

    public Owner(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return this.name;
    }

    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return name + " " + lastName;
    }
}

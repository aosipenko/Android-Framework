package org.prog.manager;

import java.util.*;

public class PoliceStation {

    private final List<Car> availableCars;
    private final List<Owner> owners;

    private final HashMap<Car, Owner> ownedCars;

    public PoliceStation() {
        availableCars = new ArrayList<>();
        owners = new ArrayList<>();
        ownedCars = new HashMap<>();
    }

    public void registerCar(Car car) {
        availableCars.add(car);
    }

    public void registerOwner(Owner owner) {
        owners.add(owner);
    }

    public void assignOwner(Car car, Owner owner) {
        if (availableCars.contains(car)) {
            availableCars.remove(car);
            ownedCars.put(car, owner);
        } else {
            throw new RuntimeException("Car is already owned by someone!");
        }
        System.out.println("Cars left unassigned: " + availableCars.size());
    }

    public void printOwner(Car car) {
        Owner owner = ownedCars.get(car);
        System.out.println(owner.getName() + " " + owner.getLastName());
    }

    public void printCars(Owner owner) {
        Set<Map.Entry<Car, Owner>> ownedVehicles = ownedCars.entrySet();
        List<Car> carsOwnedByPerson = new ArrayList<>();

        for (Map.Entry<Car, Owner> entry : ownedVehicles) {
            if (entry.getValue().equals(owner)) {
                carsOwnedByPerson.add(entry.getKey());
            }
        }

        for (Car c : carsOwnedByPerson) {
            System.out.println(c.getSerialNumber());
        }
    }

    public void printAvailableCars() {
        //TODO: print all cars that have not been assigned to anyone
        //TODO: If all cars have been assigned, print 'no cars available at the moment!'
    }

    public void printAllCarsThatHaveOwners() {
        //TODO: print all cars that HAVE been assigned to anyone
        //TODO: If NO cars have been assigned, print 'no cars assigned at the moment!'
    }

    public void printOwnerOfACarWithCertainPlateNumbers(String plateNumber) {
        //TODO: If plate number does not exist -> throw RuntimeException
        //TODO: If plate number is found, but there is no owner -> print car with plate not assigned
        //TODO: print owner of a car with plate numbers
    }
}

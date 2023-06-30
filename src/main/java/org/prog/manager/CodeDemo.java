package org.prog.manager;

public class CodeDemo {

    //TODO: here or in class fields add plate numbers to all cars
    private static final Car carOne = new Car("AA1234");
    private static final Car carTwo = new Car("LK5678");
    private static final Car carThree = new Car("PO91011");
    private static final Car carFour = new Car("GH1213");
    private static final Car carFive = new Car("QR2021");
    private static final Owner ben = new Owner("Ben", "Ben");
    private static final Owner bob = new Owner("Bob", "Bob");
    private static final Owner alice = new Owner("Alice", "Alice");
    private static final Owner susan = new Owner("Susan", "Susan");


    public static void main(String[] args) {
        PoliceStation policeStation = new PoliceStation();
        fillPoliceDB(policeStation);

        policeStation.assignOwner(carOne, alice);
        policeStation.assignOwner(carTwo, alice);
        policeStation.assignOwner(carThree, bob);
        policeStation.assignOwner(carFour, ben);
        policeStation.assignOwner(carFive, susan);

        policeStation.printOwner(carFive);
        policeStation.printCars(alice);
    }

    private static void fillPoliceDB(PoliceStation policeStation) {
        //TODO: here or in class fields add plate numbers to all cars

        policeStation.registerCar(carOne);
        policeStation.registerCar(carTwo);
        policeStation.registerCar(carThree);
        policeStation.registerCar(carFour);
        policeStation.registerCar(carFive);

        policeStation.registerOwner(bob);
        policeStation.registerOwner(ben);
        policeStation.registerOwner(alice);
        policeStation.registerOwner(susan);
    }
}

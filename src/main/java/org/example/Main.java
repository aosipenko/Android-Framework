package org.example;

//import

import org.prog.poly.Bus;

public class Main {

  public static void main(String[] args) {
//    Car myCar = new Car();
//    myCar.drive("Kyiv");
//    Truck myTruck = new Truck();
//    myTruck.drive("Lviv");
//    HugeTruck hugeTruck = new HugeTruck();
//    hugeTruck.drive("Kharkiv");

//    CarStation carStation = new CarStation();
//    carStation.carRace();

    Bus bus = new Bus();
    Bus bus2 = new Bus();
//    Bus bus3 = bus;
    bus.color = "green";
    bus2.color = "red";
//    bus3.color = "green";
//    bus.goTo("Warsaw");
//    bus.goTo("Warsaw", 20);
//    bus.goTo("Warsaw", 20, "Lviv");
//    bus.goTo("Warsaw", 20, "Lviv", LocalDate.now().plusDays(2));

//    Object o = new Object();
//    System.out.println(bus);
//    System.out.println(o);
//
//    int i = 1;
//    int j = 2;
//
//    System.out.println(bus == bus2);
//    System.out.println(bus == bus3);
    System.out.println(bus.equals(bus2));
    System.out.println(bus2.equals(bus));

    String s = "";
    System.out.println(s.toLowerCase());
    s = null;
    System.out.println(s.toLowerCase());
  }
}

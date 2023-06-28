package org.example;

public class Truck extends Car {

  public void putCargo() {

  }

  @Override
  public void drive(String destination) {
    System.out.println("This truck delivers cargo to " + destination);
  }
}

package org.example;

public class Car {

  public String color;

  String plateNumber = "AA0000AA";

  private String serialNumber = "GHASDIUH120398102938";

  protected String carBrand = "Mazda";

  public void drive(String destination) {
    System.out.println("Car with serial number " + searialNo() + " is going to " + destination);
  }

  private String searialNo() {
    return serialNumber.toUpperCase();
  }
}

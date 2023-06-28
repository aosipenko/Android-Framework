package org.prog.poly;

import java.time.LocalDate;

public class Bus {

  public String color;

  public void goTo(String destination) {
    goTo(destination, 50);
  }

  public void goTo(String destination, int amountOfPassengers) {
    goTo(destination, amountOfPassengers, "nowhere");
  }

  public void goTo(String destination, int amountOfPassengers, String throughCity) {
    goTo(destination, amountOfPassengers, throughCity, LocalDate.now().plusDays(1));
  }

  public void goTo(String destination, int amountOfPassengers, String throughCity, LocalDate date) {
    System.out.println("Bus is going to " + destination + " with " + amountOfPassengers +
        " stopping " + throughCity + " arriving at " + date.toString());
  }

  public void setColor(String color) {
    this.color = color;
  }

  @Override
  public String toString() {
    return "Bus is " + color;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Bus) {
      return this.color.equals(((Bus) o).color);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return color.hashCode();
  }
}

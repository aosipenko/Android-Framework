package org.prog.poly;

public class BMW implements ICarControl {
  @Override
  public void turnLeft() {
    System.out.println("BMW turns left with signal");
  }

  @Override
  public void turnRight() {
    System.out.println("BMW turns right with signal");
  }

  @Override
  public void accelerate() {
    System.out.println("wroooom");
  }

  @Override
  public void brake() {
    System.out.println("BMW doesnt stop");
  }
}

package org.prog.poly;

public class Bolid implements ICarControl {
  @Override
  public void turnLeft() {
    System.out.println("Bolid turns Left");
  }

  @Override
  public void turnRight() {
    System.out.println("Bolid turns Right");
  }

  @Override
  public void accelerate() {
    System.out.println("WROOOOM");
  }

  @Override
  public void brake() {
    System.out.println("Bolid is stopping");
  }
}

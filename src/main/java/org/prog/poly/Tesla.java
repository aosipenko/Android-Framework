package org.prog.poly;

public class Tesla implements ICarControl {

  public String color = "white";

  @Override
  public void turnLeft() {
    System.out.println("Tesla turns left");
  }

  @Override
  public void turnRight() {
    System.out.println("Tesla turns right");
  }

  @Override
  public void accelerate() {
    System.out.println("Tesla goes sssshhhh");
  }

  @Override
  public void brake() {
    System.out.println("Tesla stops");
  }
}

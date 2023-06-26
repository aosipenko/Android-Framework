package org.example;

public class DemoMain {

//  public static final Car DEMO_CAR = new Car();

  public static void main(String[] args) {
//    DEMO_CAR.color = "red";
//    System.out.println(DEMO_CAR.color);
//    DEMO_CAR.color = "blue";
//    System.out.println(DEMO_CAR.color);

    int[] intArray = new int[5];
    intArray[0] = 1;
    intArray[1] = 10;
    intArray[2] = 5;
    intArray[3] = 119;
    intArray[4] = -70;

    System.out.println(intArray[0]);
    System.out.println(intArray[1]);
    System.out.println(intArray[2]);
    System.out.println(intArray[3]);
    System.out.println(intArray[4]);

    int[] myArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    System.out.println(myArray);

    Car[] cars = new Car[5];
    cars[0] = new Car();
    cars[1] = new Car();
    cars[2] = new Car();
    cars[3] = new Car();
    cars[4] = new Car();
  }
}

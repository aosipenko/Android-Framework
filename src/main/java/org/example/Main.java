package org.example;

//import

import java.math.BigDecimal;

public class Main {

  public static String aString = "a";

  public static void main(String[] args) {
    short s = 1;
    boolean b = true;
    int i = 1;
    long l = 1;
    double d = 11.11D;
    float f = 25.00006F;
    BigDecimal bd = new BigDecimal("5000000000.00001");
    String string = "aaaaa";
    Object o = new Object();

//    System.out.println(i + 1);
//    System.out.println(i - 1);
//    System.out.println(i * 2);
//    System.out.println(i / 2);
    System.out.println(Math.pow(4D, 7D));
//    System.out.println(5 % 2);
//    System.out.println(5 ^ 2);
//
//    f = 25.00F;
//
//    System.out.println(string + "bbb");
//    System.out.println((1 + 2) + string);
//    System.out.println(1 + 2 + string);


    System.out.println(i);
    someMethod(i);
    System.out.println(i);

    Car myCar = new Car();
    Car sameCar = myCar;
    Car bobsCar = new Car();
    bobsCar.color = "green";

    myCar.color = "red";
    System.out.println(myCar.color);
    System.out.println(sameCar.color);
    paintCar(myCar, "blue");
    System.out.println(sameCar.color);
    paintCar(sameCar, "yellow");
    System.out.println(myCar.color);
    System.out.println(bobsCar.color);

    myCar.drive("Lviv");
    sameCar.drive("Odessa");
    bobsCar.drive("Los Angeles");

    Car.lable = "Honda";
    System.out.println(bobsCar.lable);
    Car.lable = "Pontiac";
    System.out.println(myCar.lable);
  }

  public static void someMethod(int input) {
    input = input + 10;
    System.out.println(input);
  }

  public static void paintCar(Car carToPaint, String newCarColor){
    carToPaint.color = newCarColor;
  }
}

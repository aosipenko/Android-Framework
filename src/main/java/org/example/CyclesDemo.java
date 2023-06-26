package org.example;

import java.util.Random;

public class CyclesDemo {

  public static void main(String[] args) {
    Random random = new Random();
    int i = random.nextInt(10);
    int j = random.nextInt(10);
    int k = random.nextInt(10);
    System.out.println(i);
    System.out.println(j);
    System.out.println(k);
    if (i < 3) {
      System.out.println("int is below 3");
    } else if (i > 7) {
      System.out.println("int is above 7");
    } else {
      System.out.println("int is between 3 and 7");
    }

    if (Boolean.parseBoolean("0")) {
      System.out.println("boolean is 1");
    } else {
      System.out.println("boolean is 0");
    }

    if (i < 5 && j < 5) {
      System.out.println("both i and j are blow 5");
    } else if (i >= 5 && j < 5) {
      System.out.println("i >= 5 and j < 5");
    } else if (i < 5 && j >= 5) {
      System.out.println("i < 5 and j >= 5");
    } else {
      System.out.println("Both i and j are greater than 5");
    }

    if ((i < 5 && j < 5) || k > 5) {
      System.out.println("i and j < 5 OR k is greater than 5");
    } else {
      System.out.println("-------");
    }
  }
}

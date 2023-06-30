package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionsDemo {

    private static String s = "s";

    public static void main(String[] args) {
        try {
            s = null;
            printStuff();
            readFile1();
            System.out.println("post read file");
        } catch (FileNotFoundException e) {
            System.out.println("There was an exception!");
        } catch (Exception e) {
            System.out.println("NPE!");
        } finally {
            System.out.println("This happens always!");
        }
        System.out.println("test");
        System.out.println(getNumber());
    }

    private static void readFile1() throws FileNotFoundException {
        readFile2();
    }

    private static void readFile2() throws FileNotFoundException {
        readFile3();
    }

    private static void readFile3() throws FileNotFoundException {
        readFile4();
    }

    private static void readFile4() throws FileNotFoundException {
        readFile5();
    }

    private static void readFile5() throws FileNotFoundException {
        FileReader reader = new FileReader(new File("asdasd.json"));
        System.out.println("method!");
    }

    private static void printStuff() {
        System.out.println(s.length());
    }

    private static int getNumber() {
        try {
            smth(false);
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }

    private static void smth(boolean flag) {
        if (flag) {
            throw new RuntimeException();
        }
    }

}

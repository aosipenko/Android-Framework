package org.example.coll;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListDemo {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a1");
        list.add("a2");
        list.add("b1");
        list.add("b2");
        list.add("c1");
        list.add("c1.5");
        list.add("c2");
        list.add("d1");
        list.add("e1");
        list.add("e2");
        list.add("e3123");
        list.add("e4asd;kasudlkjhasd987123");
        list.add("e5123123897129837");
        list.add("e6!!!!");
        list.add(null);

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");

//        list.forEach(System.out::println);
//        list.forEach(ListDemo::smth);
//        System.out.println(list.stream().allMatch(item -> item != null));
//        if (list.stream().anyMatch(item -> item != null)) {
//
//        }
//
//        System.out.println(list.stream()
//                .filter(s -> s != null)
//                .filter(s -> s.contains("e"))
//                .anyMatch(s -> s.contains("5")));
//
//        list.stream().filter(s -> s != null).map(s -> s.length()).forEach(System.out::println);
//        List<Integer> stringLengths = list.stream().filter(Objects::nonNull).map(String::length).filter(i -> i >= 3).toList();
//        stringLengths.forEach(System.out::println);

    }

    public static void smth(String input) {
        System.out.println(input + "asd");
    }
}

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
        list.add("e3");
        list.add("e4");
        list.add("e5");
        list.add("e6");
        list.add(null);

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }

        for (String s : list) {
            System.out.println(s);
        }
    }
}

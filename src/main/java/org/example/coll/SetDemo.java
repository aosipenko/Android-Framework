package org.example.coll;

import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetDemo {

    public static void main(String[] args) {
        HashSet<String> stringSet = new HashSet<>();
        stringSet.add("a");
        stringSet.add("a");
        stringSet.add("a");
        stringSet.add("a");
        stringSet.add("b");
        stringSet.add("c");

        System.out.println(stringSet.size());

//        SortedSet<String> sortedSet = new TreeSet<>();
//        sortedSet.add(null);
//        System.out.println(stringSet.size());
    }
}

package org.example.coll;

import java.util.HashMap;

public class MapDemo {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("key_1", "value_1");
        map.put("key_2", "value_1");
        map.put("key_3", "value_2");
        System.out.println(map.get("key_1"));
        System.out.println(map.get("key_2"));
        System.out.println(map.get("key_3"));
        System.out.println(map.get("key_4"));
        map.put("key_1", "value_3");
        System.out.println(map.get("key_1"));
        map.put(null, "null key value");
        System.out.println(map.get(null));
    }
}

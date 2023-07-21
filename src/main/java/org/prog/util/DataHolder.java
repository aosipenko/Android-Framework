package org.prog.util;

import java.util.HashMap;

public class DataHolder {

    private final static DataHolder instance = new DataHolder();

    private final HashMap<String, Object> holder;

    private DataHolder() {
        holder = new HashMap();
    }

    public static DataHolder getInstance() {
        return instance;
    }

    public void add(String alias, Object o) {
        holder.put(alias, o);
    }

    public Object get(String alias) {
        return holder.get(alias);
    }

    public <T> T getWithDynamicType(String alias) {
        return (T) holder.get(alias);
    }

    public void reset() {
        holder.clear();
    }
}

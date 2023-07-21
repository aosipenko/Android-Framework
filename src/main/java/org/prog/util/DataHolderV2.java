package org.prog.util;

import org.apache.commons.collections4.map.MultiKeyMap;

public class DataHolderV2 {

    private final MultiKeyMap holder;

    private final static DataHolderV2 instance = new DataHolderV2();

    private DataHolderV2() {
        holder = new MultiKeyMap();
    }

    public static DataHolderV2 getInstance() {
        return instance;
    }

    public void add(String alias, Object o) {
        holder.put(alias, o.getClass(), o);
    }

    public <T> T get(String alias, Class<T> type) {
        return (T) holder.get(alias, type);
    }

    public void reset() {
        holder.clear();
    }
}

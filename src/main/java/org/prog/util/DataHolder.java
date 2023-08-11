package org.prog.util;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;

@Component
public class DataHolder {

    private final HashMap<String, Object> holder = new HashMap<>();

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

    @PostConstruct
    public void postCreate() {
        System.out.println("Data Holder Created");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Data Holder about to be destroyed");
    }
}

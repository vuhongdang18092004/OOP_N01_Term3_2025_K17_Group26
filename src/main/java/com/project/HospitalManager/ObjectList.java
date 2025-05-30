package com.project.HospitalManager;

import java.util.*;

public class ObjectList<T> {
    private Map<Integer, T> map = new HashMap<>();

    public void create(T obj) {
        int id = getId(obj);
        map.put(id, obj);
    }

    public Optional<T> read(int id) {
        return Optional.ofNullable(map.get(id));
    }

    public void update(int id, T obj) {
        map.put(id, obj);
    }

    public void delete(int id) {
        map.remove(id);
    }

    private int getId(T obj) {
        try {
            return (int) obj.getClass().getMethod("getId").invoke(obj);
        } catch (Exception e) {
            throw new RuntimeException("Object must have getId() method returning int");
        }
    }
}

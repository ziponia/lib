package com.ziponia.util;

import java.util.*;

public class PercentageList<T> extends ArrayList<T> {

    private Queue<T> space = new LinkedList<T>();

    public void add(T item, int percent) {
        super.add(item);

        super.clear();
        while (!space.isEmpty()) {
            T t = space.poll();
            super.add(t);
        }
        for (int i = 0; i < percent; i++) {
            super.add(item);
        }
        Collections.shuffle(this);

        space.addAll(this);
    }

    public T draw() {
        return space.poll();
    }

    public T get() {
        Collections.shuffle(this);
        return super.get(0);
    }

    public boolean isEmpty() {
        return space.isEmpty();
    }
}

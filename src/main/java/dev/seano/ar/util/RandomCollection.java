/*
 * Licensed under the Attribution-ShareAlike 3.0 Unported (CC BY-SA 3.0).
 * https://creativecommons.org/licenses/by-sa/3.0/
 *
 * (ref. https://stackoverflow.com/help/licensing)
 */

package dev.seano.ar.util;

import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

/**
 * Define a list of entries (E) with a specific weight.
 * Used to randomly pick an entry, taking the weight into account.
 *
 * @author <a href="https://stackoverflow.com/users/57695/peter-lawrey">@Peter Lawrey</a>
 */
public class RandomCollection<E> {
    private final NavigableMap<Double, E> map = new TreeMap<>();
    private final Random random;
    private double total = 0;

    public RandomCollection() {
        this(new Random());
    }

    public RandomCollection(Random random) {
        this.random = random;
    }

    @SuppressWarnings("UnusedReturnValue")
    public RandomCollection<E> add(double weight, E result) {
        if (weight <= 0) return this;
        total += weight;
        map.put(total, result);
        return this;
    }

    public E next() {
        double value = random.nextDouble() * total;
        return map.higherEntry(value)
                .getValue();
    }
}

package dev.seano.ar.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Define a list of entries (T) with a specific weight.
 * Used to randomly pick an entry, taking the weight into account.
 *
 * @author <a href="https://gamedev.stackexchange.com/users/21890/philipp">@Philipp</a>
 */
public class WeightedRandomBag<T> {

    private class Entry {
        double accumulatedWeight;
        T object;
    }

    private final List<Entry> entries = new ArrayList<>();
    private double accumulatedWeight;
    private final Random rand = new Random();

    public void addEntry(T object, double weight) {
        accumulatedWeight += weight;
        Entry e = new Entry();
        e.object = object;
        e.accumulatedWeight = accumulatedWeight;
        entries.add(e);
    }

    public T getRandom() {
        double r = rand.nextDouble() * accumulatedWeight;
        for (Entry entry : entries) {
            if (entry.accumulatedWeight >= r) {
                return entry.object;
            }
        }
        return null;
    }
}

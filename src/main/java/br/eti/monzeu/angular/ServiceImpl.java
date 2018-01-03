package br.eti.monzeu.angular;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

public class ServiceImpl implements Service {

    private Map<String, Country> storage = new ConcurrentHashMap<String, Country>();

    public void create(final Country c) {
        Country oldValue = storage.putIfAbsent(c.getGeoCode(), c);

        if (oldValue != null) {
            throw new RuntimeException("Country already exists");
        }
    }

    public void update(final Country c) {
        storage.compute(c.getGeoCode(), new BiFunction<String, Country, Country>() {
            public Country apply(String t, Country u) {
                if (u == null) {
                    throw new RuntimeException("Country does not exist");
                }
                return c;
            }
        });
    }

    public void delete(String geoCode) {
        Country oldValue = storage.remove(geoCode);

        if (oldValue == null) {
            throw new RuntimeException("Country does not exist");
        }
    }

    public Country read(String geoCode) {
        return storage.get(geoCode);
    }

    public Iterable<Country> readAll() {
        return storage.values();
    }

}

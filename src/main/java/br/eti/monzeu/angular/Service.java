package br.eti.monzeu.angular;

/**
 * Very Simpre CRUD.
 *
 * @author framon
 */
public interface Service {

    void create(Country c);

    void update(Country c);

    void delete(String geoCode);

    Country read(String geoCode);

    Iterable<Country> readAll();
}

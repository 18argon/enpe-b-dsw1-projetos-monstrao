package br.ufscar.dc.dsw.promonstraorest.dao;

import br.ufscar.dc.dsw.promonstraorest.domain.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICityDAO extends CrudRepository<City, Long> {

    List<City> findAll();

    @Query("SELECT c from City c WHERE c.name = :name")
    City findByName(String name);

    City save(City city);
}

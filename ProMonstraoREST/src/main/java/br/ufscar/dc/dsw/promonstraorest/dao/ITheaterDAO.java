package br.ufscar.dc.dsw.promonstraorest.dao;

import br.ufscar.dc.dsw.promonstraorest.domain.Theater;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ITheaterDAO extends CrudRepository<Theater, Long> {

    Theater save(Theater s);

    List<Theater> findAll();

    Optional<Theater> findById(Long id);

    void deleteById(Long id);

    @Query("SELECT t FROM Theater t, City c WHERE c.id = :cityId AND c.id = t.city")
    List<Theater> findAllByCityId(Long cityId);
}

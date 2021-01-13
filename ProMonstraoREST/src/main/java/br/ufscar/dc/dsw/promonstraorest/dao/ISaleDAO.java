package br.ufscar.dc.dsw.promonstraorest.dao;

import br.ufscar.dc.dsw.promonstraorest.domain.Sale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ISaleDAO extends CrudRepository<Sale, Long> {

    @Query("SELECT s FROM Sale s WHERE s.theater.id = :theaterId")
    List<Sale> findAllByTheater(Long theaterId);

    @Query("SELECT s FROM Sale s WHERE s.website.id = :websiteId")
    List<Sale> findAllByWebsite(Long websiteId);

    List<Sale> findAll();

    @Override
    Optional<Sale> findById(Long aLong);

    @Query("SELECT s FROM Sale s WHERE (s.website.id = :wid OR s.theater.id = :tid) AND s.date = :date")
    Sale hasConflict(Long wid, Long tid, String date);

    Sale save(Sale s);
}

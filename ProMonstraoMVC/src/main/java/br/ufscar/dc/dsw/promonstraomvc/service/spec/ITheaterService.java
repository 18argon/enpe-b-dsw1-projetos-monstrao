package br.ufscar.dc.dsw.promonstraomvc.service.spec;

import br.ufscar.dc.dsw.promonstraomvc.domain.dto.CreateTheaterDTO;
import br.ufscar.dc.dsw.promonstraomvc.domain.dto.EditTheaterDTO;
import br.ufscar.dc.dsw.promonstraomvc.domain.Theater;
import br.ufscar.dc.dsw.promonstraomvc.exception.EmailAlreadyUsedException;

import java.util.List;
import java.util.Optional;

public interface ITheaterService {

    Theater save(Theater theater);

    Theater update(EditTheaterDTO theater);

    Theater create(CreateTheaterDTO website) throws EmailAlreadyUsedException;

    List<Theater> findAll();

    Optional<Theater> findById(Long id);

    void deleteById(Long id);

    List<Theater> findAllByCityId(Long cityId);
}

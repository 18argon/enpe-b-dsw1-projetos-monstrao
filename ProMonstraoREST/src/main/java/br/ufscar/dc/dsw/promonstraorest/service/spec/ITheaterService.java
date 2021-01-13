package br.ufscar.dc.dsw.promonstraorest.service.spec;

import br.ufscar.dc.dsw.promonstraorest.domain.dto.CreateTheaterDTO;
import br.ufscar.dc.dsw.promonstraorest.domain.dto.EditTheaterDTO;
import br.ufscar.dc.dsw.promonstraorest.domain.Theater;
import br.ufscar.dc.dsw.promonstraorest.exception.EmailAlreadyUsedException;

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

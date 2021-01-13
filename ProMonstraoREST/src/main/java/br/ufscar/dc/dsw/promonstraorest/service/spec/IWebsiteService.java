package br.ufscar.dc.dsw.promonstraorest.service.spec;

import br.ufscar.dc.dsw.promonstraorest.domain.Website;
import br.ufscar.dc.dsw.promonstraorest.domain.dto.CreateWebsiteDTO;
import br.ufscar.dc.dsw.promonstraorest.domain.dto.EditWebsiteDTO;
import br.ufscar.dc.dsw.promonstraorest.exception.EmailAlreadyUsedException;

import java.util.List;
import java.util.Optional;

public interface IWebsiteService {

    Website save(Website website);

    Website update(EditWebsiteDTO dto);

    Website create(CreateWebsiteDTO dto) throws EmailAlreadyUsedException;

    List<Website> findAll();

    Optional<Website> findById(Long id);

    void deleteById(Long id);
}

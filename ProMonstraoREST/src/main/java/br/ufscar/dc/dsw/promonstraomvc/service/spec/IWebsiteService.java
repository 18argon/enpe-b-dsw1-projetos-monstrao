package br.ufscar.dc.dsw.promonstraomvc.service.spec;

import br.ufscar.dc.dsw.promonstraomvc.domain.Website;
import br.ufscar.dc.dsw.promonstraomvc.domain.dto.CreateWebsiteDTO;
import br.ufscar.dc.dsw.promonstraomvc.domain.dto.EditWebsiteDTO;
import br.ufscar.dc.dsw.promonstraomvc.exception.EmailAlreadyUsedException;

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

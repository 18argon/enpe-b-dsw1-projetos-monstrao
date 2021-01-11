package br.ufscar.dc.dsw.promonstraomvc.service.spec;

import br.ufscar.dc.dsw.promonstraomvc.domain.Website;
import br.ufscar.dc.dsw.promonstraomvc.exception.EmailAlreadyUsedException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;

public interface IWebsiteService {

    Website save(Website website);

    Website update(Website updateWebsiteDTO);

    Website create(Website website) throws EmailAlreadyUsedException;

    List<Website> findAll();

    Optional<Website> findById(Long id);

    void deleteById(Long id);
}

package br.ufscar.dc.dsw.promonstraomvc.service.spec;

import br.ufscar.dc.dsw.promonstraomvc.domain.Sale;

import java.util.List;

public interface ISaleService {

    List<Sale> findAllByTheater(Long theaterId);

    List<Sale> findAllByWebsite(Long websiteId);

    Sale save(Sale sale);
}

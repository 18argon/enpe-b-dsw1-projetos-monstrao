package br.ufscar.dc.dsw.promonstraorest.service.spec;

import br.ufscar.dc.dsw.promonstraorest.domain.Sale;
import br.ufscar.dc.dsw.promonstraorest.domain.dto.CreateTheaterSaleDTO;
import br.ufscar.dc.dsw.promonstraorest.domain.dto.CreateWebsiteSaleDTO;

import java.util.List;
import java.util.Optional;

public interface ISaleService {

    Sale createTheaterSale(Long theaterId, CreateTheaterSaleDTO dto);

    Sale createWebsiteSale(Long websiteId, CreateWebsiteSaleDTO dto);

    List<Sale> findAllByTheater(Long theaterId);

    List<Sale> findAllByWebsite(Long websiteId);

    List<Sale> findAll();

    Optional<Sale> findById(Long id);

    Sale save(Sale sale);
}

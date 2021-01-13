package br.ufscar.dc.dsw.promonstraomvc.service.spec;

import br.ufscar.dc.dsw.promonstraomvc.domain.Sale;
import br.ufscar.dc.dsw.promonstraomvc.domain.dto.CreateTheaterSaleDTO;
import br.ufscar.dc.dsw.promonstraomvc.domain.dto.CreateWebsiteSaleDTO;

import java.util.List;

public interface ISaleService {

    Sale createTheaterSale(Long theaterId, CreateTheaterSaleDTO dto);

    Sale createWebsiteSale(Long websiteId, CreateWebsiteSaleDTO dto);

    List<Sale> findAllByTheater(Long theaterId);

    List<Sale> findAllByWebsite(Long websiteId);

    Sale save(Sale sale);
}

package br.ufscar.dc.dsw.promonstraomvc.service.impl;

import br.ufscar.dc.dsw.promonstraomvc.dao.ISaleDAO;
import br.ufscar.dc.dsw.promonstraomvc.domain.Sale;
import br.ufscar.dc.dsw.promonstraomvc.service.spec.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaleService implements ISaleService {

    private final ISaleDAO saleDAO;

    @Autowired
    public SaleService(ISaleDAO saleDAO) {
        this.saleDAO = saleDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Sale> findAllByTheater(Long theaterId) {
        return saleDAO.findAllByTheater(theaterId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Sale> findAllByWebsite(Long websiteId) {
        return saleDAO.findAllByWebsite(websiteId);
    }

    @Override
    public Sale save(Sale sale) {
        return saleDAO.save(sale);
    }
}

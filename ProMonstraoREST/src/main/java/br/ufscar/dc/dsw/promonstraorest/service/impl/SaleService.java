package br.ufscar.dc.dsw.promonstraorest.service.impl;

import br.ufscar.dc.dsw.promonstraorest.dao.ISaleDAO;
import br.ufscar.dc.dsw.promonstraorest.domain.Sale;
import br.ufscar.dc.dsw.promonstraorest.domain.Theater;
import br.ufscar.dc.dsw.promonstraorest.domain.Website;
import br.ufscar.dc.dsw.promonstraorest.domain.dto.CreateTheaterSaleDTO;
import br.ufscar.dc.dsw.promonstraorest.domain.dto.CreateWebsiteSaleDTO;
import br.ufscar.dc.dsw.promonstraorest.service.spec.ISaleService;
import br.ufscar.dc.dsw.promonstraorest.service.spec.ITheaterService;
import br.ufscar.dc.dsw.promonstraorest.service.spec.IWebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService implements ISaleService {

    private final ISaleDAO saleDAO;

    private final IWebsiteService websiteService;

    private final ITheaterService theaterService;

    @Autowired
    public SaleService(ISaleDAO saleDAO, IWebsiteService websiteService, ITheaterService theaterService) {
        this.saleDAO = saleDAO;
        this.websiteService = websiteService;
        this.theaterService = theaterService;
    }

    @Override
    public Sale createTheaterSale(Long theaterId, CreateTheaterSaleDTO dto) {

        Long websiteId = Long.parseLong(dto.getWebsiteId());

        if (checkConflict(websiteId, theaterId, dto.getDate())) {
            return null;
        }

        Double price = Double.parseDouble(dto.getPrice());

        Optional<Theater> ot = theaterService.findById(theaterId);
        Optional<Website> ow = websiteService.findById(websiteId);

        if (!ot.isPresent() || !ow.isPresent()) {
            return null;
        }
        Theater t = ot.get();
        Website w = ow.get();

        Sale s = new Sale(dto.getPlayName(), price, dto.getDate(), t, w);
        return saleDAO.save(s);
    }

    @Override
    public Sale createWebsiteSale(Long websiteId, CreateWebsiteSaleDTO dto) {

        Long theaterId = Long.parseLong(dto.getTheaterId());

        if (checkConflict(websiteId, theaterId, dto.getDate())) {
            return null;
        }

        Double price = Double.parseDouble(dto.getPrice());

        Optional<Theater> ot = theaterService.findById(theaterId);
        Optional<Website> ow = websiteService.findById(websiteId);

        if (!ot.isPresent() || !ow.isPresent()) {
            return null;
        }
        Theater t = ot.get();
        Website w = ow.get();

        Sale s = new Sale(dto.getPlayName(), price, dto.getDate(), t, w);
        return saleDAO.save(s);
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
    public List<Sale> findAll() {
        return saleDAO.findAll();
    }

    @Override
    public Optional<Sale> findById(Long id) {
        return saleDAO.findById(id);
    }

    @Override
    public Sale save(Sale sale) {
        return saleDAO.save(sale);
    }

    private boolean checkConflict(Long wid, Long tid, String date) {
        return saleDAO.hasConflict(wid, tid, date) != null;
    }
}

package br.ufscar.dc.dsw.promonstraomvc.service.impl;

import br.ufscar.dc.dsw.promonstraomvc.dao.ICityDAO;
import br.ufscar.dc.dsw.promonstraomvc.domain.City;
import br.ufscar.dc.dsw.promonstraomvc.service.spec.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityService implements ICityService {

    private final ICityDAO cityDAO;

    @Autowired
    public CityService(ICityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }

    @Override
    public City save(City city) {
        return cityDAO.save(city);
    }

    @Override
    public City findByName(String name) {
        return cityDAO.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<City> findAll() {
        return cityDAO.findAll();
    }
}

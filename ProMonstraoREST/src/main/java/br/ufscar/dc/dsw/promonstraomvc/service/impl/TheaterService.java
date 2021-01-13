package br.ufscar.dc.dsw.promonstraomvc.service.impl;

import br.ufscar.dc.dsw.promonstraomvc.dao.ITheaterDAO;
import br.ufscar.dc.dsw.promonstraomvc.domain.*;
import br.ufscar.dc.dsw.promonstraomvc.domain.Theater;
import br.ufscar.dc.dsw.promonstraomvc.domain.dto.CreateTheaterDTO;
import br.ufscar.dc.dsw.promonstraomvc.domain.dto.EditTheaterDTO;
import br.ufscar.dc.dsw.promonstraomvc.exception.EmailAlreadyUsedException;
import br.ufscar.dc.dsw.promonstraomvc.service.spec.ICityService;
import br.ufscar.dc.dsw.promonstraomvc.service.spec.ITheaterService;
import br.ufscar.dc.dsw.promonstraomvc.service.spec.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterService implements ITheaterService {

    private final ITheaterDAO theaterDAO;

    private final IUserService userService;

    private final ICityService cityService;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public TheaterService(ITheaterDAO theaterDAO, UserService userService, ICityService cityService, BCryptPasswordEncoder passwordEncoder) {
        this.theaterDAO = theaterDAO;
        this.userService = userService;
        this.cityService = cityService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Theater save(Theater theater) {
        return theaterDAO.save(theater);
    }

    @Override
    public Theater update(EditTheaterDTO dto) {
        Optional<Theater> ot = theaterDAO.findById(Long.parseLong(dto.getId()));
        if (!ot.isPresent()) {
            return null;
        }
        Theater t = ot.get();
        t.setName(dto.getName());
        t.setCnpj(dto.getCnpj());
        City city = cityService.findByName(dto.getCity());
        System.out.println(city);
        if (city == null) {
            city = new City(dto.getCity());
            cityService.save(city);
        }
        t.setCity(city);
        return theaterDAO.save(t);
    }

    @Override
    public Theater create(CreateTheaterDTO dto) throws EmailAlreadyUsedException {
        User user = userService.findByEmail(dto.getEmail());
        if (user != null) {
            throw new EmailAlreadyUsedException();
        }

        String hashedPassword = passwordEncoder.encode(dto.getPassword());
        City city = cityService.findByName(dto.getCity());
        if (city == null) {
            city = new City(dto.getCity());
            cityService.save(city);
        }

        Theater t = new Theater(dto.getEmail(), hashedPassword, dto.getName(), dto.getCnpj(), city);
        return theaterDAO.save(t);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Theater> findAll() {
        return theaterDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Theater> findById(Long id) {
        return theaterDAO.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Theater> findAllByCityId(Long cityId) {
        return theaterDAO.findAllByCityId(cityId);
    }

    @Override
    public void deleteById(Long id) {
        theaterDAO.deleteById(id);
    }
}

package br.ufscar.dc.dsw.promonstraorest.service.impl;

import br.ufscar.dc.dsw.promonstraorest.dao.IUserDAO;
import br.ufscar.dc.dsw.promonstraorest.dao.IWebsiteDAO;
import br.ufscar.dc.dsw.promonstraorest.domain.User;
import br.ufscar.dc.dsw.promonstraorest.domain.Website;
import br.ufscar.dc.dsw.promonstraorest.domain.dto.CreateWebsiteDTO;
import br.ufscar.dc.dsw.promonstraorest.domain.dto.EditWebsiteDTO;
import br.ufscar.dc.dsw.promonstraorest.exception.EmailAlreadyUsedException;
import br.ufscar.dc.dsw.promonstraorest.service.spec.IWebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class WebsiteService implements IWebsiteService {

    private final IWebsiteDAO websiteDAO;

    private final IUserDAO userDAO;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public WebsiteService(IWebsiteDAO websiteDAO, IUserDAO userDAO, BCryptPasswordEncoder passwordEncoder) {
        this.websiteDAO = websiteDAO;
        this.passwordEncoder = passwordEncoder;
        this.userDAO = userDAO;
    }

    @Override
    public Website save(Website website) {
        return websiteDAO.save(website);
    }

    @Override
    public Website update(EditWebsiteDTO dto) {
        Optional<Website> ow = websiteDAO.findById(Long.parseLong(dto.getId()));
        if (!ow.isPresent()) {
            return null;
        }
        Website w = ow.get();
        w.setName(dto.getName());
        w.setUrl(dto.getUrl());
        w.setPhoneNumber(dto.getPhoneNumber());
        return websiteDAO.save(w);
    }

    @Override
    public Website create(CreateWebsiteDTO dto) throws EmailAlreadyUsedException {
        User user = userDAO.findByEmail(dto.getEmail());
        if (user != null) {
            throw new EmailAlreadyUsedException();
        }

        String hashedPassword = passwordEncoder.encode(dto.getPassword());
        Website w = new Website(dto.getEmail(), hashedPassword, dto.getName(), dto.getUrl(), dto.getPhoneNumber());
        return websiteDAO.save(w);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Website> findAll() {
        return websiteDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Website> findById(Long id) {
        return websiteDAO.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        websiteDAO.deleteById(id);
    }
}

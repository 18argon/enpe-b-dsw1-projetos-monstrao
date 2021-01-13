package br.ufscar.dc.dsw.promonstraomvc.service.impl;

import br.ufscar.dc.dsw.promonstraomvc.dao.IAdminDAO;
import br.ufscar.dc.dsw.promonstraomvc.domain.Admin;
import br.ufscar.dc.dsw.promonstraomvc.service.spec.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService {

    private final IAdminDAO adminDAO;

    @Autowired
    public AdminService(IAdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    @Override
    public Admin save(Admin admin) {
        return adminDAO.save(admin);
    }
}

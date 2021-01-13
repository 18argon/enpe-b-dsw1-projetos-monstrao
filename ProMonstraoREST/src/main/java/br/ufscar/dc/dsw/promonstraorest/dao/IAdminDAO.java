package br.ufscar.dc.dsw.promonstraorest.dao;

import br.ufscar.dc.dsw.promonstraorest.domain.Admin;
import org.springframework.data.repository.CrudRepository;

public interface IAdminDAO extends CrudRepository<Admin, Long> {

    Admin save(Admin s);
}

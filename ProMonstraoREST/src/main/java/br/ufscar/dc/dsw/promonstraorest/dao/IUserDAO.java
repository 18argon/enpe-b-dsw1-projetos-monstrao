package br.ufscar.dc.dsw.promonstraorest.dao;

import br.ufscar.dc.dsw.promonstraorest.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUserDAO extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(String email);
}

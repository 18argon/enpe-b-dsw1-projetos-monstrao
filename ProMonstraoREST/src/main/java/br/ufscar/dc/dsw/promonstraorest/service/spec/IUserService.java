package br.ufscar.dc.dsw.promonstraorest.service.spec;

import br.ufscar.dc.dsw.promonstraorest.domain.User;

public interface IUserService {

    User findByEmail(String email);
}

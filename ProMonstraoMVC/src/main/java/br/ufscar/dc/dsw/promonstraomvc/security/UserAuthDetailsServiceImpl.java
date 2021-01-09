package br.ufscar.dc.dsw.promonstraomvc.security;

import br.ufscar.dc.dsw.promonstraomvc.domain.User;
import br.ufscar.dc.dsw.promonstraomvc.service.spec.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthDetailsServiceImpl implements UserDetailsService {

    private final IUserService userService;

    @Autowired
    public UserAuthDetailsServiceImpl(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new UserAuthDetails(user);
    }
}

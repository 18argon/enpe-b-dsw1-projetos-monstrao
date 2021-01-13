package br.ufscar.dc.dsw.promonstraorest.domain;

import javax.persistence.Entity;

@Entity
public class Admin extends User {

    private static final String ROLE_NAME = "ROLE_ADMIN";

    public Admin() {
        super(ROLE_NAME);
    }

    public Admin(String email, String password, String name) {
        super(ROLE_NAME);
        setEmail(email);
        setPassword(password);
        setName(name);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "email='" + this.getEmail() + '\'' +
                ", name='" + this.getName() + '\'' +
                ", role='" + this.getRole() + '\'' +
                '}';
    }
}

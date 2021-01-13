package br.ufscar.dc.dsw.promonstraorest.exception;

public class EmailAlreadyUsedException extends Exception{

    public EmailAlreadyUsedException() {
        super("Email already used");
    }
}

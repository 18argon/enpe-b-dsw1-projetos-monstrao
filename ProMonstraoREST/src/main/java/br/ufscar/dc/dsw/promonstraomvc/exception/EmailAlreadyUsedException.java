package br.ufscar.dc.dsw.promonstraomvc.exception;

public class EmailAlreadyUsedException extends Exception{

    public EmailAlreadyUsedException() {
        super("Email already used");
    }
}

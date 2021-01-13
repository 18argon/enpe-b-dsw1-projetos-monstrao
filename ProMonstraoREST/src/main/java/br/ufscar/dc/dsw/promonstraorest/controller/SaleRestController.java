package br.ufscar.dc.dsw.promonstraorest.controller;

import br.ufscar.dc.dsw.promonstraorest.service.spec.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController()
public class SaleRestController {

    private final ISaleService saleService;

    @Autowired
    public SaleRestController(ISaleService saleService) {
        this.saleService = saleService;
    }

    // TODO: GET http://localhost:8080/promocoes

    // TODO: GET http://localhost:8080/promocoes/{id}

    // TODO: GET http://localhost:8080/promocoes/sites/{id}

    // TODO: GET http://localhost:8080/promocoes/teatros/{id}

}

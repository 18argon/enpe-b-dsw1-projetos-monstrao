package br.ufscar.dc.dsw.promonstraorest.controller;

import br.ufscar.dc.dsw.promonstraorest.service.spec.ITheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController("/teatros")
public class TheaterRestController {

    private final ITheaterService theaterService;

    @Autowired
    public TheaterRestController(ITheaterService theaterService) {
        this.theaterService = theaterService;
    }

    // TODO: POST http://localhost:8080/teatros

    // TODO: GET http://localhost:8080/teatros

    // TODO: GET http://localhost:8080/teatros/{id}

    // TODO: GET http://localhost:8080/teatros/cidades/{nome}

    // TODO: PUT http://localhost:8080/teatros/{id}

    // TODO: DELETE http://localhost:8080/teatros/{id}
}

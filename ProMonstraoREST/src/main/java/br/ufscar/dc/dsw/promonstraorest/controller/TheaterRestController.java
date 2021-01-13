package br.ufscar.dc.dsw.promonstraorest.controller;

import br.ufscar.dc.dsw.promonstraorest.domain.City;
import br.ufscar.dc.dsw.promonstraorest.domain.Theater;
import br.ufscar.dc.dsw.promonstraorest.domain.dto.CreateTheaterDTO;
import br.ufscar.dc.dsw.promonstraorest.domain.dto.EditTheaterDTO;
import br.ufscar.dc.dsw.promonstraorest.exception.EmailAlreadyUsedException;
import br.ufscar.dc.dsw.promonstraorest.service.spec.ICityService;
import br.ufscar.dc.dsw.promonstraorest.service.spec.ITheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController("/teatros")
public class TheaterRestController {

    private final ITheaterService theaterService;

    private final ICityService cityService;

    @Autowired
    public TheaterRestController(ITheaterService theaterService, ICityService cityService) {
        this.theaterService = theaterService;
        this.cityService = cityService;
    }

    @PostMapping(value="/teatros",headers = "Accept=application/json")
    public ResponseEntity<Theater> create(@Valid @RequestBody CreateTheaterDTO dto, BindingResult result) {
        System.out.println(dto.toString());
        System.out.println(result.toString());
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(null);
        }
        try {
            Theater theater = theaterService.create(dto);
            return ResponseEntity.ok(theater);
        } catch (EmailAlreadyUsedException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/teatros")
    public ResponseEntity<List<Theater>> list() {
        List<Theater> theaters = theaterService.findAll();
        if (theaters.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(theaters);
    }

    @GetMapping("/teatros/{id}")
    public ResponseEntity<Theater> getById(@PathVariable("id") Long id) {
        Optional<Theater> ot = theaterService.findById(id);
        return ot.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/teatros/cidades/{nome}")
    public ResponseEntity<List<Theater>> getByCity(@PathVariable("nome") String name) {
        City city = cityService.findByName(name);
        if (city == null) return ResponseEntity.ok(new ArrayList<>());

        List<Theater> theaters = theaterService.findAllByCityId(city.getId());
        return ResponseEntity.ok(theaters);
    }

    @PutMapping(path = "/teatros/{id}", headers = "Accept=application/json")
    public ResponseEntity<Theater> update(@PathVariable("id") Long id,
                                          @Valid @RequestBody EditTheaterDTO dto, BindingResult result) {
        System.out.println(dto.toString());
        System.out.println(result.toString());
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(null);
        }
        dto.setId(id.toString());
        Theater theater = theaterService.update(dto);
        if (theater == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(theater);
    }

    @DeleteMapping("/teatros/{id}")
    public ResponseEntity<Theater> delete(@PathVariable("id") Long id) {
        Optional<Theater> ot = theaterService.findById(id);
        if (!ot.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        theaterService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

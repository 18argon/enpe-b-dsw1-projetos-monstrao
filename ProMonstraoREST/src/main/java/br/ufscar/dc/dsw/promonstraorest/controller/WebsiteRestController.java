package br.ufscar.dc.dsw.promonstraorest.controller;

import br.ufscar.dc.dsw.promonstraorest.domain.Website;
import br.ufscar.dc.dsw.promonstraorest.domain.dto.CreateWebsiteDTO;
import br.ufscar.dc.dsw.promonstraorest.domain.dto.EditWebsiteDTO;
import br.ufscar.dc.dsw.promonstraorest.exception.EmailAlreadyUsedException;
import br.ufscar.dc.dsw.promonstraorest.service.spec.IWebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController()
public class WebsiteRestController {

    private final IWebsiteService websiteService;

    @Autowired
    public WebsiteRestController(IWebsiteService websiteService) {
        this.websiteService = websiteService;
    }

    @PostMapping(value="/sites",headers = "Accept=application/json")
    public ResponseEntity<Website> create(@Valid @RequestBody CreateWebsiteDTO dto, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(null);
        }
        try {
            Website website = websiteService.create(dto);
            return ResponseEntity.ok(website);
        } catch (EmailAlreadyUsedException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/sites")
    public ResponseEntity<List<Website>> list() {
        List<Website> websites = websiteService.findAll();
        if (websites.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(websites);
    }

    @GetMapping(path = "/sites/{id}")
    public ResponseEntity<Website> getById(@PathVariable("id") Long id) {
        Optional<Website> ow = websiteService.findById(id);
        return ow.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/sites/{id}", headers = "Accept=application/json")
    public ResponseEntity<Website> update(@PathVariable("id") Long id,
                                          @Valid @RequestBody EditWebsiteDTO dto, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(null);
        }
        dto.setId(id.toString());
        Website website = websiteService.update(dto);
        if (website == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(website);
    }

    @DeleteMapping(path = "/sites/{id}")
    public ResponseEntity<Website> delete(@PathVariable("id") Long id) {
        Optional<Website> ow = websiteService.findById(id);
        if (!ow.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        websiteService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

package br.ufscar.dc.dsw.promonstraorest.controller;

import br.ufscar.dc.dsw.promonstraorest.domain.Sale;
import br.ufscar.dc.dsw.promonstraorest.service.spec.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController()
public class SaleRestController {

    private final ISaleService saleService;

    @Autowired
    public SaleRestController(ISaleService saleService) {
        this.saleService = saleService;
    }

    // TODO: GET http://localhost:8080/promocoes
    @GetMapping("/promocoes")
    public ResponseEntity<List<Sale>> list() {
        List<Sale> sales = saleService.findAll();
        if (sales.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sales);
    }

    // TODO: GET http://localhost:8080/promocoes/{id}
    @GetMapping("/promocoes/{id}")
    public ResponseEntity<Sale> getById(@PathVariable Long id) {
        Optional<Sale> os = saleService.findById(id);
        return os.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // TODO: GET http://localhost:8080/promocoes/sites/{id}
    @GetMapping("/promocoes/sites/{id}")
    public ResponseEntity<List<Sale>> findAllByWebsiteId(@PathVariable Long id) {
        List<Sale> sales = saleService.findAllByWebsite(id);
        if (sales.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sales);
    }

    // TODO: GET http://localhost:8080/promocoes/teatros/{id}
    @GetMapping("/promocoes/teatros/{id}")
    public ResponseEntity<List<Sale>> findAllByTheaterId(@PathVariable Long id) {
        List<Sale> sales = saleService.findAllByTheater(id);
        if (sales.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sales);
    }
}

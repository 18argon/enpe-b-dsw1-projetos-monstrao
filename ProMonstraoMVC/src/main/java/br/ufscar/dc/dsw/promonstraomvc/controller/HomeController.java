package br.ufscar.dc.dsw.promonstraomvc.controller;

import br.ufscar.dc.dsw.promonstraomvc.domain.Theater;
import br.ufscar.dc.dsw.promonstraomvc.service.impl.CityService;
import br.ufscar.dc.dsw.promonstraomvc.service.impl.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class HomeController {

    final TheaterService theaterService;

    final CityService cityService;

    @Autowired()
    public HomeController(TheaterService theaterService, CityService cityService) {
        this.theaterService = theaterService;
        this.cityService = cityService;
    }

    @GetMapping("/")
    public String home(ModelMap model, @RequestParam(required = false) String city) {
        model.addAttribute("cities", cityService.findAll());


        if (city == null) {
            model.addAttribute("theaters", theaterService.findAll());
        } else {
            try {
                Long id = Long.parseLong(city);
                model.addAttribute("theaters", theaterService.findAllByCityId(id));
            } catch (NumberFormatException e) {
                model.addAttribute("theaters", new ArrayList<Theater>());
            }
        }
        return "home";
    }

}

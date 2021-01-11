package br.ufscar.dc.dsw.promonstraomvc.controller;

import br.ufscar.dc.dsw.promonstraomvc.domain.dto.CreateTheaterDTO;
import br.ufscar.dc.dsw.promonstraomvc.domain.dto.EditTheaterDTO;
import br.ufscar.dc.dsw.promonstraomvc.domain.Theater;
import br.ufscar.dc.dsw.promonstraomvc.exception.EmailAlreadyUsedException;
import br.ufscar.dc.dsw.promonstraomvc.service.impl.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/theaters")
public class TheaterController {
    private final TheaterService theaterService;


    @Autowired
    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("theaters", theaterService.findAll());
        return "theaters/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        if (!id.isEmpty()) {
            try {
                Long idParsed = Long.parseLong(id);
                theaterService.deleteById(idParsed);
            } catch (NumberFormatException e) {
                //do nothing and redirect
            }
        }

        return "redirect:/theaters";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable String id, ModelMap modelMap) {
        if (!id.isEmpty()) {
            try {
                Long idParsed = Long.parseLong(id);
                Optional<Theater> theater = theaterService.findById(idParsed);

                if (!theater.isPresent()) {
                    return "redirect:/theaters";
                }
                modelMap.addAttribute("theater", theater.get());
            } catch (NumberFormatException e) {
                return "redirect:/theaters";
            }
        }

        return "theaters/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid EditTheaterDTO theater, BindingResult result) {
        List<FieldError> errorsToKeep = result.getFieldErrors().stream()
                .filter(e -> !e.getField().equals("password"))
                .collect(Collectors.toList());
        result = new BeanPropertyBindingResult(theater, "theater");
        errorsToKeep.forEach(result::addError);

        System.out.println(result.getAllErrors());
        System.out.println(theater);

        if (result.hasErrors()) {
            return "/theaters/edit";
        }

        theaterService.update(theater);
        return "redirect:/theaters";
    }

    @GetMapping("/create")
    public String createForm() {
        return "theaters/create";
    }

    @PostMapping("/create")
    public String create(@Valid CreateTheaterDTO theater, BindingResult result) {
        if (result.hasErrors()) {
            return "/theaters/create";
        }

        try {
            theaterService.create(theater);
        } catch (EmailAlreadyUsedException e) {
            return "/theaters/create";
        }
        return "redirect:/theaters";
    }
}

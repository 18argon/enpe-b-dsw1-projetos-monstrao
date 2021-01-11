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
@RequestMapping("/theater")
public class TheaterController {
    private final TheaterService theaterService;


    @Autowired
    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("theaters", theaterService.findAll());
        return "theater/index";
    }

    @GetMapping("/delete/{id}")
    public RedirectView delete(@PathVariable String id) {
        if (!id.isEmpty()) {
            try {
                Long idParsed = Long.parseLong(id);
                theaterService.deleteById(idParsed);
            } catch (NumberFormatException e) {
                //do nothing and redirect
            }
        }

        return new RedirectView("/theater");
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable String id, ModelMap modelMap) {
        if (!id.isEmpty()) {
            try {
                Long idParsed = Long.parseLong(id);
                Optional<Theater> theater = theaterService.findById(idParsed);

                if (!theater.isPresent()) {
                    return "redirect:/theater";
                }
                modelMap.addAttribute("theater", theater.get());
            } catch (NumberFormatException e) {
                return "redirect:/theater";
            }
        }

        return "theater/edit";
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
            return "/theater/edit";
        }

        theaterService.update(theater);
        return "redirect:/theater";
    }

    @GetMapping("/create")
    public String createForm() {
        return "theater/create";
    }

    @PostMapping("/create")
    public String create(@Valid CreateTheaterDTO theater, BindingResult result) {
        if (result.hasErrors()) {
            return "/theater/create";
        }

        try {
            theaterService.create(theater);
        } catch (EmailAlreadyUsedException e) {
            return "/theater/create";
        }
        return "redirect:/theater";
    }
}

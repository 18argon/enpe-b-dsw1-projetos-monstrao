package br.ufscar.dc.dsw.promonstraomvc.controller;

import br.ufscar.dc.dsw.promonstraomvc.domain.Website;
import br.ufscar.dc.dsw.promonstraomvc.domain.dto.CreateWebsiteDTO;
import br.ufscar.dc.dsw.promonstraomvc.domain.dto.EditWebsiteDTO;
import br.ufscar.dc.dsw.promonstraomvc.exception.EmailAlreadyUsedException;
import br.ufscar.dc.dsw.promonstraomvc.service.impl.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/websites")
public class WebsiteController {
    private final WebsiteService websiteService;


    @Autowired
    public WebsiteController(WebsiteService websiteService) {
        this.websiteService = websiteService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("websites", websiteService.findAll());
        return "websites/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        if (!id.isEmpty()) {
            try {
                Long idParsed = Long.parseLong(id);
                websiteService.deleteById(idParsed);
            } catch (NumberFormatException e) {
                //do nothing and redirect
            }
        }

        return "redirect:/websites";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable String id, ModelMap modelMap) {
        if (!id.isEmpty()) {
            try {
                Long idParsed = Long.parseLong(id);
                Optional<Website> website = websiteService.findById(idParsed);

                if (!website.isPresent()) {
                    return "redirect:/websites";
                }
                modelMap.addAttribute("website", website.get());
            } catch (NumberFormatException e) {
                return "redirect:/websites";
            }
        }

        return "websites/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid EditWebsiteDTO dto, BindingResult result) {
        if (result.hasErrors()) {
            return "/websites/edit";
        }

        websiteService.update(dto);
        return "redirect:/websites";
    }

    @GetMapping("/create")
    public String createForm() {
        return "websites/create";
    }

    @PostMapping("/create")
    public String create(@Valid CreateWebsiteDTO dto, BindingResult result) {
        if (result.hasErrors()) {
            return "/websites/create";
        }

        try {
            websiteService.create(dto);
        } catch (EmailAlreadyUsedException e) {
            return "/websites/create";
        }
        return "redirect:/websites";
    }
}

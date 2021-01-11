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
@RequestMapping("/website")
public class WebsiteController {
    private final WebsiteService websiteService;


    @Autowired
    public WebsiteController(WebsiteService websiteService) {
        this.websiteService = websiteService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("websites", websiteService.findAll());
        return "website/index";
    }

    @GetMapping("/delete/{id}")
    public RedirectView delete(@PathVariable String id) {
        if (!id.isEmpty()) {
            try {
                Long idParsed = Long.parseLong(id);
                websiteService.deleteById(idParsed);
            } catch (NumberFormatException e) {
                //do nothing and redirect
            }
        }

        return new RedirectView("/website");
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable String id, ModelMap modelMap) {
        if (!id.isEmpty()) {
            try {
                Long idParsed = Long.parseLong(id);
                Optional<Website> website = websiteService.findById(idParsed);

                if (!website.isPresent()) {
                    return "redirect:/website";
                }
                modelMap.addAttribute("website", website.get());
            } catch (NumberFormatException e) {
                return "redirect:/website";
            }
        }

        return "website/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid EditWebsiteDTO dto, BindingResult result) {
        if (result.hasErrors()) {
            return "/website/edit";
        }

        websiteService.update(dto);
        return "redirect:/website";
    }

    @GetMapping("/create")
    public String createForm() {
        return "website/create";
    }

    @PostMapping("/create")
    public String create(@Valid CreateWebsiteDTO dto, BindingResult result) {
        if (result.hasErrors()) {
            return "/website/create";
        }

        try {
            websiteService.create(dto);
        } catch (EmailAlreadyUsedException e) {
            return "/website/create";
        }
        return "redirect:/website";
    }
}

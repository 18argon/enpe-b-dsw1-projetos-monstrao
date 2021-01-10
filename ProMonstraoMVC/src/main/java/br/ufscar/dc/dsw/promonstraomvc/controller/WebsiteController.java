package br.ufscar.dc.dsw.promonstraomvc.controller;

import br.ufscar.dc.dsw.promonstraomvc.service.impl.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}

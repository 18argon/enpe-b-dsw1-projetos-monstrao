package br.ufscar.dc.dsw.promonstraomvc.controller;

import br.ufscar.dc.dsw.promonstraomvc.domain.Sale;
import br.ufscar.dc.dsw.promonstraomvc.domain.dto.CreateTheaterSaleDTO;
import br.ufscar.dc.dsw.promonstraomvc.domain.dto.CreateWebsiteSaleDTO;
import br.ufscar.dc.dsw.promonstraomvc.security.UserAuthDetails;
import br.ufscar.dc.dsw.promonstraomvc.service.spec.ICityService;
import br.ufscar.dc.dsw.promonstraomvc.service.spec.ISaleService;
import br.ufscar.dc.dsw.promonstraomvc.service.spec.ITheaterService;
import br.ufscar.dc.dsw.promonstraomvc.service.spec.IWebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/sales")
public class SalesController {

    final ISaleService saleService;

    final IWebsiteService websiteService;

    final ITheaterService theaterService;

    @Autowired()
    public SalesController(ISaleService saleService, IWebsiteService websiteService, ITheaterService theaterService) {
        this.saleService = saleService;
        this.websiteService = websiteService;
        this.theaterService = theaterService;
    }

    @GetMapping("/websites")
    public String websites(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserAuthDetails userAuthDetails = (UserAuthDetails) authentication.getPrincipal();
        Long userId = userAuthDetails.getUser().getId();

        model.addAttribute("sales", saleService.findAllByWebsite(userId));

        return "sales/websites/index";
    }

    @GetMapping("/websites/create")
    public String websitesCreateForm(ModelMap model) {
        model.addAttribute("theaters", theaterService.findAll());

        return "sales/websites/create";
    }

    @PostMapping("/websites/create")
    public String websitesCreate(@Valid CreateWebsiteSaleDTO dto, BindingResult result) {
        if (result.hasErrors()) {
            return "/sales/websites/create";
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserAuthDetails userAuthDetails = (UserAuthDetails) authentication.getPrincipal();
        Long userId = userAuthDetails.getUser().getId();

        Sale s = saleService.createWebsiteSale(userId, dto);

        if (s == null) return "/sales/websites/create";
        return "redirect:/sales/websites";
    }

    @GetMapping("/theaters")
    public String theaters(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserAuthDetails userAuthDetails = (UserAuthDetails) authentication.getPrincipal();
        Long userId = userAuthDetails.getUser().getId();

        model.addAttribute("sales", saleService.findAllByTheater(userId));

        return "sales/theaters/index";
    }

    @GetMapping("/theaters/create")
    public String theatersCreateForm(ModelMap model) {
        model.addAttribute("websites", websiteService.findAll());

        return "sales/theaters/create";
    }

    @PostMapping("/theaters/create")
    public String theatersCreate(@Valid CreateTheaterSaleDTO dto, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "/sales/theaters/create";
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserAuthDetails userAuthDetails = (UserAuthDetails) authentication.getPrincipal();
        Long userId = userAuthDetails.getUser().getId();

        Sale s = saleService.createTheaterSale(userId, dto);
        if (s == null) {
            return "/sales/websites/create";
        }

        return "redirect:/sales/theaters";
    }
}

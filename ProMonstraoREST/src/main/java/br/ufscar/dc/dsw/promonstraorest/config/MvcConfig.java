package br.ufscar.dc.dsw.promonstraorest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = "br.ufscar.dc.dsw.promonstraorest.config")
public class MvcConfig  implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
    }
}

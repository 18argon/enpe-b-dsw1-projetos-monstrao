package br.ufscar.dc.dsw.promonstraomvc;

import br.ufscar.dc.dsw.promonstraomvc.dao.*;
import br.ufscar.dc.dsw.promonstraomvc.domain.*;
import br.ufscar.dc.dsw.promonstraomvc.service.impl.AdminService;
import br.ufscar.dc.dsw.promonstraomvc.service.spec.IAdminService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Timestamp;
import java.util.Calendar;

@SpringBootApplication
public class ProMonstraoMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProMonstraoMvcApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ICityDAO cityDAO, ITheaterDAO theaterDAO, IWebsiteDAO websiteDAO,
                                  ISaleDAO saleDAO, IUserDAO userDao, AdminService adminService, BCryptPasswordEncoder passwordEncoder) {
        return (args) -> {

            Admin admin = new Admin("admin@email.com", passwordEncoder.encode("admin"), "admin");
            adminService.save(admin);

            City c1 = new City("São Carlos");
            cityDAO.save(c1);
            City c2 = new City("Sorocaba");
            cityDAO.save(c2);

            Website w1 = new Website("website1@email.com", passwordEncoder.encode("senha"), "Website 1",
                    "https://website1.com", "(15) 98766-5431");
            websiteDAO.save(w1);
            Website w2 = new Website("website2@email.com", passwordEncoder.encode("senha"), "Website 2",
                    "https://website2.com", "(15) 98766-5432");
            websiteDAO.save(w2);
            Website w3 = new Website("website3@email.com", passwordEncoder.encode("senha"), "Website 3",
                    "https://website3.com", "(15) 98766-5433");
            websiteDAO.save(w3);

            Theater t1 = new Theater("theater1@email.com", passwordEncoder.encode("senha"), "Theater 1",
                    "123456789/341", c1);
            theaterDAO.save(t1);
            Theater t2 = new Theater("theater2@email.com", passwordEncoder.encode("senha"), "Theater 2",
                    "123456789/342", c2);
            theaterDAO.save(t2);
            Theater t3 = new Theater("theater3@email.com", passwordEncoder.encode("senha"), "Theater 3",
                    "123456789/343", c2);
            theaterDAO.save(t3);

            Sale s1 = new Sale("O Quebra-Nozes", 19.99,
                    new Timestamp(Calendar.getInstance().getTimeInMillis()), t1, w1);
            saleDAO.save(s1);

            Sale s2 = new Sale("Romeu e Julieta", 19.99,
                    new Timestamp(Calendar.getInstance().getTimeInMillis()), t2, w1);
            saleDAO.save(s2);

            Sale s3 = new Sale("O Lago dos Cisnes", 19.99,
                    new Timestamp(Calendar.getInstance().getTimeInMillis()), t3, w2);
            saleDAO.save(s3);

            Sale s4 = new Sale("Hamlet", 19.99,
                    new Timestamp(Calendar.getInstance().getTimeInMillis()), t1, w3);
            saleDAO.save(s4);

            System.out.println(userDao.findByEmail("website1@email.com"));

//            System.out.println("\nTheater's list");
//            theaterDAO.findAll().forEach(System.out::println);
//
//            System.out.println("\nWebsites' list");
//            websiteDAO.findAll().forEach(System.out::println);
//
//            System.out.println("\nSales of " + t1.getName());
//            saleDAO.findAllByTheater(t1.getId()).forEach(System.out::println);
//
//            System.out.println("\nSales of " + t2.getName());
//            saleDAO.findAllByTheater(t2.getId()).forEach(System.out::println);
//
//            System.out.println("\nSales of " + w2.getName());
//            saleDAO.findAllByTheater(w2.getId()).forEach(System.out::println);
//
//            System.out.println("\nTheaters in Sorocaba");
//            theaterDAO.findAllByCity("São Carlos").forEach(System.out::println);
//
//            theaterDAO.delete(t1);
        };
    }
}

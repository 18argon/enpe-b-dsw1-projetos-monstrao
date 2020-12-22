package br.ufscar.dc.dsw.promonstraomvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Entity
public class Sale extends AbstractEntity<Long> {

    @NotBlank
    @Column(name = "play_name", nullable = false, length = 128)
    private String playName;

    @Column(nullable = false, precision = 2)
    private Double price;

    @Column(nullable = false)
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @ManyToOne
    @JoinColumn(name = "website_id")
    private Website website;

    public Sale(String playName, Double price, Timestamp date, Theater theater, Website website) {
        this.playName = playName;
        this.price = price;
        this.date = date;
        this.theater = theater;
        this.website = website;
    }

    public Sale() {

    }

    public String getPlayName() {
        return playName;
    }

    public void setPlayName(String name) {
        this.playName = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public Website getWebsite() {
        return website;
    }

    public void setWebsite(Website website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "playName='" + playName + '\'' +
                ", price=" + price +
                ", date=" + date.toString() +
                ", theater=" + theater.getName() +
                ", website=" + website.getName() +
                '}';
    }
}

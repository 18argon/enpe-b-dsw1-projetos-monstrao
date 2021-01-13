package br.ufscar.dc.dsw.promonstraorest.domain.dto;

import javax.validation.constraints.NotBlank;

public class CreateTheaterSaleDTO {

    @NotBlank
    private String websiteId;

    @NotBlank
    private String playName;

    @NotBlank
    private String price;

    @NotBlank
    private String date;

    public String getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(String websiteId) {
        this.websiteId = websiteId;
    }

    public String getPlayName() {
        return playName;
    }

    public void setPlayName(String playName) {
        this.playName = playName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

package br.ufscar.dc.dsw.promonstraorest.domain.dto;

import javax.validation.constraints.NotBlank;

public class CreateWebsiteSaleDTO {

    @NotBlank
    private String theaterId;

    @NotBlank
    private String playName;

    @NotBlank
    private String price;

    @NotBlank
    private String date;

    public String getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(String theaterId) {
        this.theaterId = theaterId;
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

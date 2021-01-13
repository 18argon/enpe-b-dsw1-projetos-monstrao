package br.ufscar.dc.dsw.promonstraorest.domain.dto;


import javax.validation.constraints.NotBlank;

public class EditTheaterDTO {

    @NotBlank
    private String id;

    @NotBlank
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private String cnpj;

    @NotBlank
    private String city;

    public EditTheaterDTO(String id, String email, String name, String cnpj, String city) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.cnpj = cnpj;
        this.city = city;
    }

    public EditTheaterDTO() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "EditTheaterDto{" +
                "email='" + this.email + '\'' +
                ", name='" + this.name + '\'' +
                ", cnpj='" + this.cnpj + '\'' +
                ", city='" + this.city + '\'' +
                '}';
    }
}

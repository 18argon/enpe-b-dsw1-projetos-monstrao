package br.ufscar.dc.dsw.promonstraomvc.domain.dto;


import javax.validation.constraints.NotBlank;

public class CreateTheaterDTO {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    @NotBlank
    private String cnpj;

    @NotBlank
    private String city;

    public CreateTheaterDTO(String email, String password, String name, String cnpj, String city) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.cnpj = cnpj;
        this.city = city;
    }

    public CreateTheaterDTO() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "CreateTheaterDto{" +
                "email='" + this.email + '\'' +
                ", name='" + this.name + '\'' +
                ", cnpj='" + this.cnpj + '\'' +
                ", city='" + this.city + '\'' +
                '}';
    }
}

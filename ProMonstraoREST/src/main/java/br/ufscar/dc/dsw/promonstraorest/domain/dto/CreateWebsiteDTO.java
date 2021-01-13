package br.ufscar.dc.dsw.promonstraorest.domain.dto;


import javax.validation.constraints.NotBlank;

public class CreateWebsiteDTO {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    @NotBlank
    private String url;

    @NotBlank
    private String phoneNumber;

    public CreateWebsiteDTO(String email, String password, String name, String url, String phoneNumber) {
        this.password = password;
        this.email = email;
        this.name = name;
        this.url = url;
        this.phoneNumber = phoneNumber;
    }

    public CreateWebsiteDTO() {

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "CreateWebsiteDto{" +
                "email='" + this.email + '\'' +
                ", name='" + this.name + '\'' +
                ", url='" + this.url + '\'' +
                ", phoneNumber='" + this.phoneNumber + '\'' +
                '}';
    }
}

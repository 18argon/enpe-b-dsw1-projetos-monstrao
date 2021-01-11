package br.ufscar.dc.dsw.promonstraomvc.domain.dto;


import javax.validation.constraints.NotBlank;

public class EditWebsiteDTO {

    @NotBlank
    private String id;

    @NotBlank
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private String url;

    @NotBlank
    private String phoneNumber;

    public EditWebsiteDTO(String id, String email, String name, String url, String phoneNumber) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.url = url;
        this.phoneNumber = phoneNumber;
    }

    public EditWebsiteDTO() {

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
        return "EditTheaterDto{" +
                "email='" + this.email + '\'' +
                ", name='" + this.name + '\'' +
                ", url='" + this.url + '\'' +
                ", phoneNumber='" + this.phoneNumber + '\'' +
                '}';
    }
}

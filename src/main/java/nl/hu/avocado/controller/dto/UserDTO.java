package nl.hu.avocado.controller.dto;

import java.util.List;

public class UserDTO {

    private Long id;
    private String voornaam;
    private String email;

    private List<Long> reports;

    public UserDTO(Long id, String voornaam, String email) {
        this.id = id;
        this.voornaam = voornaam;
        this.email = email;
    }

    public Long getId() {
        return id;
    }


    public String getVoornaam() {
        return voornaam;
    }


    public String getEmail() {
        return email;
    }


    public List<Long> getReports() {
        return reports;
    }


}

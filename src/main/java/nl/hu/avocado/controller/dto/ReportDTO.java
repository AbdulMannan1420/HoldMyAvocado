package nl.hu.avocado.controller.dto;

import java.util.List;

public class ReportDTO {


    private Long id;
    private String voornaam;

    private String email;

    private List<Long> focuspoints;

    public ReportDTO(Long id, String voornaam, String email, List<Long> focuspoints) {
        this.id = id;
        this.voornaam = voornaam;
        this.email = email;
        this.focuspoints = focuspoints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Long> getFocuspoints() {
        return focuspoints;
    }

    public void setFocuspoints(List<Long> focuspoints) {
        this.focuspoints = focuspoints;
    }
}

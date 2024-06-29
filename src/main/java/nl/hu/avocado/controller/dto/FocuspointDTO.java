package nl.hu.avocado.controller.dto;


import java.util.List;

public class FocuspointDTO {

    private long id;
    private String name;
    private String advies;
    private String logo;
    private List<Long> themes;

    private Long focuspointMailContent;

    private Long oefeningMailContent;

    public FocuspointDTO() {
    }

    public FocuspointDTO(long id, String name, String advies, String logo, List<Long> themeList, Long focuspointMailContent, Long oefeningMailContent) {
        this.id = id;
        this.name = name;
        this.advies = advies;
        this.logo = logo;
        this.themes = themeList;
        this.focuspointMailContent = focuspointMailContent;
        this.oefeningMailContent = oefeningMailContent;
    }

    // Getters en setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdvies() {
        return advies;
    }

    public void setAdvies(String advies) {
        this.advies = advies;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }


    public List<Long> getThemes() {
        return themes;
    }

    public void setThemes(List<Long> themeList) {
        this.themes = themeList;
    }

    public Long getFocuspointMailContent() {
        return focuspointMailContent;
    }

    public void setFocuspointMailContent(Long focuspointMailContent) {
        this.focuspointMailContent = focuspointMailContent;
    }

    public Long getOefeningMailContent() {
        return oefeningMailContent;
    }

    public void setOefeningMailContent(Long oefeningMailContent) {
        this.oefeningMailContent = oefeningMailContent;
    }
}

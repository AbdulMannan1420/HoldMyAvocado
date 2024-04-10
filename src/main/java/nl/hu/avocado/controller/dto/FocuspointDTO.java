package nl.hu.avocado.controller.dto;





public class FocuspointDTO {

    private Long id;

    private String naam;
    private int ranking;
    private double score;
    private String logo;

    private String advies;

    public FocuspointDTO(Long id, String naam, int ranking, double score, String logo, String advies) {
        this.id = id;
        this.naam = naam;
        this.ranking = ranking;
        this.score = score;
        this.logo = logo;
        this.advies = advies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String status) {
        this.logo = status;
    }

    public String getAdvies() {
        return advies;
    }

    public void setAdvies(String advies) {
        this.advies = advies;
    }
}
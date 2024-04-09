package nl.hu.avocado.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Focuspoint {

    @Id
    private Long id;

    private String naam;
    private int ranking;
    private double score;
    private String logo;

    private String advies;

    public Focuspoint(Long id, String naam, double score, int ranking, String logo, String advies) {
        this.id = id;
        this.naam = naam;
        this.score = score;
        this.ranking = ranking;
        this.logo = logo;
        this.advies = advies;
    }

    public Focuspoint() {
    }

    public Long getId() {
        return id;
    }


    public String getNaam() {
        return naam;
    }


    public int getRanking() {
        return ranking;
    }


    public double getScore() {
        return score;
    }


    public String getLogo() {
        return logo;
    }


    public String getAdvies() {
        return advies;
    }


}


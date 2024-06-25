package nl.hu.avocado.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;


@Getter
@Entity
public class Theme {

    @Id
    private Long id;

    private String naam;
    private int ranking;
    private double score;

    private String advies;

    public Theme(Long id, String naam, double score, int ranking, String advies) {
        this.id = id;
        this.naam = naam;
        this.score = score;
        this.ranking = ranking;
        this.advies = advies;
    }

    public Theme() {
    }


}


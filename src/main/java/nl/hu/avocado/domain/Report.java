package nl.hu.avocado.domain;

import jakarta.persistence.*;

import java.util.Comparator;
import java.util.List;

@Entity
public class Report {

    @Id
    private Long id;

    private String voornaam;

    private String email;

    private int lowestFocuspointPercentage;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Focuspoint> focuspoints;

    @OneToOne
    private Focuspoint lowestFocuspoint;

    public Report(Long id, String voornaam, String email, List<Focuspoint> focuspoints) {
        this.id = id;
        this.voornaam = voornaam;
        this.email = email;
        this.focuspoints = focuspoints;
        this.lowestFocuspoint = getLowestFocuspoint();
        this.lowestFocuspointPercentage = calculateLowestFocuspointProgressie();

    }

    public Report() {
    }

    public Focuspoint getLowestFocuspoint() {
        return focuspoints.stream()
                .min(Comparator.comparingInt(Focuspoint::getRanking))
                .orElse(null);
    }

    public int calculateLowestFocuspointProgressie() {
        if (lowestFocuspoint == null) {
            return 0;
        }

        double percentage = (lowestFocuspoint.getScore() / 4) * 100;

        return (int) Math.round(percentage);
    }


    public String getVoornaam() {
        return voornaam;
    }



    public int getLowestFocuspointPercentage() {
        return lowestFocuspointPercentage;
    }


}

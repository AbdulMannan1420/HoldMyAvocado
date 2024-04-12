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

    @OneToOne
    private Focuspoint secondLowestFocuspoint;

    @OneToOne
    private Focuspoint thirdLowestFocuspoint;

    @OneToOne
    private Focuspoint fourthLowestFocuspoint;
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
        this.secondLowestFocuspoint = getSecondLowestFocuspoint();
        this.thirdLowestFocuspoint = getThirdLowestFocuspoint();
        this.fourthLowestFocuspoint = getFourthLowestFocuspoint();

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
    public Focuspoint getSecondLowestFocuspoint() {
        return focuspoints.stream()
                .filter(f -> f.getRanking() == 2)
                .findFirst()
                .orElse(null);
    }

    public Focuspoint getThirdLowestFocuspoint() {
        return focuspoints.stream()
                .filter(f -> f.getRanking() == 3)
                .findFirst()
                .orElse(null);
    }

    public Focuspoint getFourthLowestFocuspoint() {
        return focuspoints.stream()
                .filter(f -> f.getRanking() == 4)
                .findFirst()
                .orElse(null);
    }




    public String getVoornaam() {
        return voornaam;
    }



    public int getLowestFocuspointPercentage() {
        return lowestFocuspointPercentage;
    }


}

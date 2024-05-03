package nl.hu.avocado.domain;

import jakarta.persistence.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Entity
public class Report {

    @Id
    private Long id;

    private String voornaam;

    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Focuspoint> focuspoints;

    @OneToOne
    private Focuspoint lowestFocuspoint;

    @OneToOne
    private Focuspoint chosenFocuspoint;


    public Report(Long id, String voornaam, String email, List<Focuspoint> focuspoints) {
        this.id = id;
        this.voornaam = voornaam;
        this.email = email;
        this.focuspoints = focuspoints;
        this.lowestFocuspoint = calculateLowestFocuspoint();
    }

    public Report() {
    }

    private Focuspoint calculateLowestFocuspoint() {
        return focuspoints.stream()
                .min(Comparator.comparingInt(Focuspoint::getProgress))
                .orElse(null);
    }

    public String getVoornaam() {
        return voornaam;
    }


    public Focuspoint getLowestFocuspoint() {
        return lowestFocuspoint;
    }

    public List<Focuspoint> focuspointsSortedByProgressAsc() {
        return focuspoints.stream()
                .sorted(Comparator.comparingInt(Focuspoint::getProgress))
                .collect(Collectors.toList());
    }

    public void setChosenFocuspoint(Focuspoint chosenFocuspoint) {
        this.chosenFocuspoint = chosenFocuspoint;
    }

    public String getEmail() {
        return email;
    }

    public Focuspoint getChosenFocuspoint() {
        return chosenFocuspoint;
    }
}

package nl.hu.avocado.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "person")
public class User {
    @Id
    private Long id;

    @Getter
    private String voornaam;

    @Getter
    private String email;

    @Getter
    @OneToMany(cascade = CascadeType.ALL)
    private List<Report> reports;

    public User(Long id, String voornaam, String email, List<Report> reports) {
        this.id = id;
        this.voornaam = voornaam;
        this.email = email;
        this.reports = reports;
    }

    public User() {

    }

    public Report getLastReport() {
        return reports.get(reports.size() - 1);
    }

    public Report getSecondLastReport() {
        if (reports != null && reports.size() >= 2) {
            return reports.get(reports.size() - 2);
        }
        return null;
    }

    public Focuspoint getPreviousChosenFocuspoint() {
        Report secondLastReport = this.getSecondLastReport();
        if (secondLastReport != null) {
            return secondLastReport.getChosenFocuspoint();
        }
        return null;
    }

    public Focuspoint getCurrentProgressOfPreviousChosenFocuspoint() {
        Report lastReport = this.getLastReport();
        Focuspoint previousChosenFocuspoint = this.getPreviousChosenFocuspoint();
        if (lastReport != null && previousChosenFocuspoint != null) {
            for (Focuspoint focuspoint : lastReport.getFocuspoints()) {
                if (focuspoint.getName().equals(previousChosenFocuspoint.getName())) {
                    return focuspoint;
                }
            }
        }
        return null;
    }

    public int calculateFocuspointGrowth() {
        Focuspoint previousChosenFocuspoint = this.getPreviousChosenFocuspoint();
        if (previousChosenFocuspoint != null) {
            int previous = previousChosenFocuspoint.getProgress();
            Report lastReport = this.getLastReport();
            if (lastReport != null) {
                for (Focuspoint focuspoint : lastReport.getFocuspoints()) {
                    if (focuspoint.getName().equals(previousChosenFocuspoint.getName())) {
                        return focuspoint.getProgress() - previous;
                    }
                }
            }
        }
        return 0;
    }
}

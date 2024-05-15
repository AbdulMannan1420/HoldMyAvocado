package nl.hu.avocado.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "person")
public class User {
    @Id
    private Long id;

    @Getter
    private String voornaam;

    @Getter
    private String email;


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

        return reports.get(reports.size() - 2);

    }


    public Focuspoint getPreviousFocuspoint() {
        return this.getSecondLastReport().getChosenFocuspoint();
    }

    public Focuspoint getCurrentProgressOfPreviousChosenFocuspoint() {
        for (Focuspoint focuspoint : this.getLastReport().getFocuspoints()) {
            if (focuspoint.getName().equals(this.getPreviousFocuspoint().getName())) {
                return focuspoint;
            }
        }
        return null;
    }


    public int calculateFocuspointGrowth() {

        int previous = this.getPreviousFocuspoint().getProgress();
        for (Focuspoint focuspoint : this.getLastReport().getFocuspoints()) {
            if (focuspoint.getName().equals(this.getPreviousFocuspoint().getName())) {
                return focuspoint.getProgress() - previous;
            }
        }
        return 0;

    }


}

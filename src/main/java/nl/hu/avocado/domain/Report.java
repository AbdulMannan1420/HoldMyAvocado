package nl.hu.avocado.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Entity
public class Report {

    @Id
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Focuspoint> focuspoints;

    @OneToOne
    private Focuspoint lowestFocuspoint;

    @Setter
    @OneToOne
    private Focuspoint chosenFocuspoint;


    public Report(Long id, List<Focuspoint> focuspoints) {
        this.id = id;
        this.focuspoints = focuspoints;
        this.lowestFocuspoint = calculateLowestFocuspoint();
        this.chosenFocuspoint = lowestFocuspoint;
    }

    public Report() {
    }

    private Focuspoint calculateLowestFocuspoint() {
        return focuspoints.stream()
                .min(Comparator.comparingInt(Focuspoint::getProgress))
                .orElse(null);
    }


    public List<Focuspoint> focuspointsSortedByProgressAsc() {
        return focuspoints.stream()
                .sorted(Comparator.comparingInt(Focuspoint::getProgress))
                .collect(Collectors.toList());
    }


}



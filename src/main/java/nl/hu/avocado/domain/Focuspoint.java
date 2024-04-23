package nl.hu.avocado.domain;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Focuspoint {

    @Id
    private long id;

    private String name;

    private String advies;

    private String logo;

    private int progress;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Theme> themes;

    public Focuspoint(long id, String name, String advies, String logo, List<Theme> themes) {
        this.id = id;
        this.name = name;
        this.advies = advies;
        this.logo = logo;
        this.themes = themes;
        this.progress = calculateProgress();

    }

    public Focuspoint() {
    }

    private int calculateProgress() {
        double totalScore = themes.stream()
                .mapToDouble(Theme::getScore)
                .sum();

        int maxPoints = themes.size() * 4; // Aantal themes * max punten per theme

        double percentage = (totalScore / maxPoints) * 100;

        return (int) percentage;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAdvies() {
        return advies;
    }

    public String getLogo() {
        return logo;
    }

    public int getProgress() {
        return progress;
    }

    public List<Theme> getThemes() {
        return themes;
    }
}

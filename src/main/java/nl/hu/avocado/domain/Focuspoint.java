package nl.hu.avocado.domain;


import jakarta.persistence.*;
import lombok.Getter;
import nl.hu.avocado.controller.dto.FocuspointMail2ContentDTO;

import java.util.List;

@Getter
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

    @OneToOne(cascade = CascadeType.ALL)
    private FocuspointMailContent focuspointMailContent;

    @OneToOne(cascade = CascadeType.ALL)
    private OefeningMailContent oefeningMailContent;

    @OneToOne(cascade = CascadeType.ALL)
    private FocuspointMail2Content focuspointMail2Content;

    public Focuspoint(long id, String name, String advies, String logo, List<Theme> themes, FocuspointMailContent focuspointMailContent, OefeningMailContent oefeningMailContent, FocuspointMail2Content focuspointMail2Content) {
        this.id = id;
        this.name = name;
        this.advies = advies;
        this.logo = logo;
        this.themes = themes;
        this.progress = calculateProgress();
        this.focuspointMailContent = focuspointMailContent;
        this.oefeningMailContent = oefeningMailContent;
        this.focuspointMail2Content = focuspointMail2Content;
    }

    public Focuspoint() {
    }



    private int calculateProgress() {
        double totalScore = themes.stream()
                .mapToDouble(Theme::getScore)
                .sum();

        int maxPoints = themes.size() * 4;

        double percentage = (totalScore / maxPoints) * 100;

        return (int) percentage;
    }

}

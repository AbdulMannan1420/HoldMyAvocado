package nl.hu.avocado.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class OefeningMailContent {

    @Id
    private Long id;

    private String quizContent_URL;

    private String quiz_URL;

    public OefeningMailContent(String quizContent_URL, String quiz_URL) {
        this.quizContent_URL = quizContent_URL;
        this.quiz_URL = quiz_URL;
    }

    public OefeningMailContent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuizContent_URL() {
        return quizContent_URL;
    }

    public void setQuizContent_URL(String quizContent_URL) {
        this.quizContent_URL = quizContent_URL;
    }

    public String getQuiz_URL() {
        return quiz_URL;
    }

    public void setQuiz_URL(String quiz_URL) {
        this.quiz_URL = quiz_URL;
    }


}

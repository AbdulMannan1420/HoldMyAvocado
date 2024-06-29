package nl.hu.avocado.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FocuspointMailContent {

    @Id
    private long id;

    // interesting...
    private String title;

    private String text;

    private String URL;

    private String imageURL;

    // did you know(dyk)
    private String dyk1_tekst;

    private String dyk1_URL;

    private String dyk2_tekst;

    private String dyk2_URL;

    private String dyk3_tekst;

    private String dyk3_URL;

    // snackable content(snc)
    private String snc1_tekst;

    private String snc1_URL;

    private String snc1_imageURL;

    private String snc2_tekst;

    private String snc2_URL;

    private String snc2_imageURL;

    private String snc3_tekst;

    private String snc3_URL;

    private String snc3_imageURL;

    public FocuspointMailContent(long id, String title, String text, String URL, String imageURL, String dyk1_tekst, String dyk1_URL, String dyk2_tekst, String dyk2_URL, String dyk3_tekst, String dyk3_URL, String snc1_tekst, String snc1_URL, String snc1_imageURL, String snc2_tekst, String snc2_URL, String snc2_imageURL, String snc3_tekst, String snc3_URL, String snc3_imageURL) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.URL = URL;
        this.imageURL = imageURL;
        this.dyk1_tekst = dyk1_tekst;
        this.dyk1_URL = dyk1_URL;
        this.dyk2_tekst = dyk2_tekst;
        this.dyk2_URL = dyk2_URL;
        this.dyk3_tekst = dyk3_tekst;
        this.dyk3_URL = dyk3_URL;
        this.snc1_tekst = snc1_tekst;
        this.snc1_URL = snc1_URL;
        this.snc1_imageURL = snc1_imageURL;
        this.snc2_tekst = snc2_tekst;
        this.snc2_URL = snc2_URL;
        this.snc2_imageURL = snc2_imageURL;
        this.snc3_tekst = snc3_tekst;
        this.snc3_URL = snc3_URL;
        this.snc3_imageURL = snc3_imageURL;
    }

    public FocuspointMailContent() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDyk1_tekst() {
        return dyk1_tekst;
    }

    public void setDyk1_tekst(String dyk1_tekst) {
        this.dyk1_tekst = dyk1_tekst;
    }

    public String getDyk1_URL() {
        return dyk1_URL;
    }

    public void setDyk1_URL(String dyk1_URL) {
        this.dyk1_URL = dyk1_URL;
    }

    public String getDyk2_tekst() {
        return dyk2_tekst;
    }

    public void setDyk2_tekst(String dyk2_tekst) {
        this.dyk2_tekst = dyk2_tekst;
    }

    public String getDyk2_URL() {
        return dyk2_URL;
    }

    public void setDyk2_URL(String dyk2_URL) {
        this.dyk2_URL = dyk2_URL;
    }

    public String getDyk3_tekst() {
        return dyk3_tekst;
    }

    public void setDyk3_tekst(String dyk3_tekst) {
        this.dyk3_tekst = dyk3_tekst;
    }

    public String getDyk3_URL() {
        return dyk3_URL;
    }

    public void setDyk3_URL(String dyk3_URL) {
        this.dyk3_URL = dyk3_URL;
    }

    public String getSnc1_tekst() {
        return snc1_tekst;
    }

    public void setSnc1_tekst(String snc1_tekst) {
        this.snc1_tekst = snc1_tekst;
    }

    public String getSnc1_URL() {
        return snc1_URL;
    }

    public void setSnc1_URL(String snc1_URL) {
        this.snc1_URL = snc1_URL;
    }

    public String getSnc1_imageURL() {
        return snc1_imageURL;
    }

    public void setSnc1_imageURL(String snc1_imageURL) {
        this.snc1_imageURL = snc1_imageURL;
    }

    public String getSnc2_tekst() {
        return snc2_tekst;
    }

    public void setSnc2_tekst(String snc2_tekst) {
        this.snc2_tekst = snc2_tekst;
    }

    public String getSnc2_URL() {
        return snc2_URL;
    }

    public void setSnc2_URL(String snc2_URL) {
        this.snc2_URL = snc2_URL;
    }

    public String getSnc2_imageURL() {
        return snc2_imageURL;
    }

    public void setSnc2_imageURL(String snc2_imageURL) {
        this.snc2_imageURL = snc2_imageURL;
    }

    public String getSnc3_tekst() {
        return snc3_tekst;
    }

    public void setSnc3_tekst(String snc3_tekst) {
        this.snc3_tekst = snc3_tekst;
    }

    public String getSnc3_URL() {
        return snc3_URL;
    }

    public void setSnc3_URL(String snc3_URL) {
        this.snc3_URL = snc3_URL;
    }

    public String getSnc3_imageURL() {
        return snc3_imageURL;
    }

    public void setSnc3_imageURL(String snc3_imageURL) {
        this.snc3_imageURL = snc3_imageURL;
    }
}

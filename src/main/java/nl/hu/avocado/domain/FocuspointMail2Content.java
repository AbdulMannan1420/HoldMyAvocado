package nl.hu.avocado.domain;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FocuspointMail2Content {
    @Id
    private long id;

    // Articles
    private String article_title;

    private String article_text;

    private String article_URL;

    private String article_imageURL;
    // sounds nice(sn)
    private String sn1_title;

    private String sn1_text;

    private String sn1_URL;

    private String sn1_imageURL;

    private String sn2_title;

    private String sn2_text;

    private String sn2_URL;

    private String sn2_imageURL;

    private String sn3_title;

    private String sn3_text;

    private String sn3_URL;

    private String sn3_imageURL;

    public FocuspointMail2Content(long id, String article_title, String article_text, String article_URL, String article_imageURL, String sn1_title, String sn1_text, String sn1_URL, String sn1_imageURL, String sn2_title, String sn2_text, String sn2_URL, String sn2_imageURL, String sn3_title, String sn3_text, String sn3_URL, String sn3_imageURL) {
        this.id = id;
        this.article_title = article_title;
        this.article_text = article_text;
        this.article_URL = article_URL;
        this.article_imageURL = article_imageURL;
        this.sn1_title = sn1_title;
        this.sn1_text = sn1_text;
        this.sn1_URL = sn1_URL;
        this.sn1_imageURL = sn1_imageURL;
        this.sn2_title = sn2_title;
        this.sn2_text = sn2_text;
        this.sn2_URL = sn2_URL;
        this.sn2_imageURL = sn2_imageURL;
        this.sn3_title = sn3_title;
        this.sn3_text = sn3_text;
        this.sn3_URL = sn3_URL;
        this.sn3_imageURL = sn3_imageURL;
    }

    public FocuspointMail2Content() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_text() {
        return article_text;
    }

    public void setArticle_text(String article_text) {
        this.article_text = article_text;
    }

    public String getArticle_URL() {
        return article_URL;
    }

    public void setArticle_URL(String article_URL) {
        this.article_URL = article_URL;
    }

    public String getArticle_imageURL() {
        return article_imageURL;
    }

    public void setArticle_imageURL(String article_imageURL) {
        this.article_imageURL = article_imageURL;
    }

    public String getSn1_title() {
        return sn1_title;
    }

    public void setSn1_title(String sn1_title) {
        this.sn1_title = sn1_title;
    }

    public String getSn1_text() {
        return sn1_text;
    }

    public void setSn1_text(String sn1_text) {
        this.sn1_text = sn1_text;
    }

    public String getSn1_URL() {
        return sn1_URL;
    }

    public void setSn1_URL(String sn1_URL) {
        this.sn1_URL = sn1_URL;
    }

    public String getSn1_imageURL() {
        return sn1_imageURL;
    }

    public void setSn1_imageURL(String sn1_imageURL) {
        this.sn1_imageURL = sn1_imageURL;
    }

    public String getSn2_title() {
        return sn2_title;
    }

    public void setSn2_title(String sn2_title) {
        this.sn2_title = sn2_title;
    }

    public String getSn2_text() {
        return sn2_text;
    }

    public void setSn2_text(String sn2_text) {
        this.sn2_text = sn2_text;
    }

    public String getSn2_URL() {
        return sn2_URL;
    }

    public void setSn2_URL(String sn2_URL) {
        this.sn2_URL = sn2_URL;
    }

    public String getSn2_imageURL() {
        return sn2_imageURL;
    }

    public void setSn2_imageURL(String sn2_imageURL) {
        this.sn2_imageURL = sn2_imageURL;
    }

    public String getSn3_title() {
        return sn3_title;
    }

    public void setSn3_title(String sn3_title) {
        this.sn3_title = sn3_title;
    }

    public String getSn3_text() {
        return sn3_text;
    }

    public void setSn3_text(String sn3_text) {
        this.sn3_text = sn3_text;
    }

    public String getSn3_URL() {
        return sn3_URL;
    }

    public void setSn3_URL(String sn3_URL) {
        this.sn3_URL = sn3_URL;
    }

    public String getSn3_imageURL() {
        return sn3_imageURL;
    }

    public void setSn3_imageURL(String sn3_imageURL) {
        this.sn3_imageURL = sn3_imageURL;
    }
}


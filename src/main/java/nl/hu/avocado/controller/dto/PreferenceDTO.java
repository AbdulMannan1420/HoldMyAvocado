package nl.hu.avocado.controller.dto;

public class PreferenceDTO {

    private String contentOptions;
    private String dayOptions;
    private String timeOptions;

    // Constructor, getters en setters

    public PreferenceDTO() {
    }

    public PreferenceDTO(String options, String dayPreference, String timePreference) {
        this.contentOptions = options;
        this.dayOptions = dayPreference;
        this.timeOptions = timePreference;
    }

    public String getContentOptions() {
        return contentOptions;
    }

    public void setContentOptions(String contentOptions) {
        this.contentOptions = contentOptions;
    }

    public String getDayOptions() {
        return dayOptions;
    }

    public void setDayOptions(String dayOptions) {
        this.dayOptions = dayOptions;
    }

    public String getTimeOptions() {
        return timeOptions;
    }

    public void setTimeOptions(String timeOptions) {
        this.timeOptions = timeOptions;
    }
}

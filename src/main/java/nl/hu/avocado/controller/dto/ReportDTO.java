package nl.hu.avocado.controller.dto;

import java.util.List;

public class ReportDTO {


    private Long id;

    private List<Long> focuspoints;

    public ReportDTO(Long id, List<Long> focuspoints) {
        this.id = id;
        this.focuspoints = focuspoints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<Long> getFocuspoints() {
        return focuspoints;
    }

    public void setFocuspoints(List<Long> focuspoints) {
        this.focuspoints = focuspoints;
    }
}

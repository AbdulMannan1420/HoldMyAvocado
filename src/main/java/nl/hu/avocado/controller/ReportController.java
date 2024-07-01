package nl.hu.avocado.controller;


import nl.hu.avocado.controller.dto.ReportDTO;

import nl.hu.avocado.domain.Report;

import nl.hu.avocado.service.ReportService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/report" , method = { RequestMethod.GET, RequestMethod.POST })
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping
    public void addReport(@RequestBody ReportDTO reportDTO) {
        this.reportService.addReport(reportDTO);
    }

    @PostMapping("/{email}/chosenfocuspoint/{focuspointId}")
    public void chooseFocuspoint(@PathVariable String email, @PathVariable Long focuspointId) {
        reportService.chooseFocuspoint(email, focuspointId);
    }
}

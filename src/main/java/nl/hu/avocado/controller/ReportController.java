package nl.hu.avocado.controller;


import nl.hu.avocado.controller.dto.ReportDTO;

import nl.hu.avocado.domain.Report;

import nl.hu.avocado.service.ReportService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping
    public void addReport(@RequestBody ReportDTO reportDTO) {
        this.reportService.addReport(reportDTO);
    }

    @GetMapping("{email}")
    public Report getReportByEmail(@PathVariable String email) {
        return reportService.findByEmail(email);
    }
}
package nl.hu.avocado.service;

import nl.hu.avocado.controller.dto.ReportDTO;
import nl.hu.avocado.data.ReportRepository;
import nl.hu.avocado.domain.Focuspoint;
import nl.hu.avocado.domain.Report;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Transactional
@Service
public class ReportService {

    private final ReportRepository reportRepository;
    private final FocuspointService focuspointService;

    public ReportService(ReportRepository reportRepository, FocuspointService focuspointService) {
        this.reportRepository = reportRepository;
        this.focuspointService = focuspointService;
    }


    public Report dtoIntoReport(ReportDTO dto) {
        List<Focuspoint> focuspoints = new ArrayList<>();
        for(Long f : dto.getFocuspoints()) {
            focuspoints.add(focuspointService.dtoIntoFocuspoint(this.focuspointService.findById(f)));
        }
        return new Report(dto.getId(), dto.getVoornaam(), dto.getEmail(), focuspoints);
    }

    public void addReport(ReportDTO reportDTO) {
        Report report = dtoIntoReport(reportDTO);
        reportRepository.save(report);
    }
    public Report findByEmail(String email) {
        return reportRepository.findByEmail(email)
                .orElseThrow(() -> new NoSuchElementException("Report not found with email: " + email));
    }
}

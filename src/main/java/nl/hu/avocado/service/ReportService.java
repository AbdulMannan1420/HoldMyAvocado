package nl.hu.avocado.service;

import nl.hu.avocado.controller.dto.FocuspointDTO;
import nl.hu.avocado.controller.dto.ReportDTO;
import nl.hu.avocado.data.ReportRepository;
import nl.hu.avocado.data.UserRepository;
import nl.hu.avocado.domain.Focuspoint;
import nl.hu.avocado.domain.Report;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Transactional
@Service
public class ReportService {

    private final ReportRepository reportRepository;
    private final FocuspointService focuspointService;

    private final UserRepository userRepository;

    public ReportService(ReportRepository reportRepository, FocuspointService focuspointService, UserRepository userRepository) {
        this.reportRepository = reportRepository;
        this.focuspointService = focuspointService;
        this.userRepository = userRepository;

    }


    public Report dtoIntoReport(ReportDTO dto) {
        List<Focuspoint> focuspoints = new ArrayList<>();
        for (Long f : dto.getFocuspoints()) {
            focuspoints.add(focuspointService.dtoIntoFocuspoint(this.focuspointService.findById(f)));
        }
        return new Report(dto.getId(), focuspoints);
    }

    public ReportDTO reportIntoDto(Report report) {
        List<Long> focuspoints = report.getFocuspoints().stream().map(Focuspoint::getId).collect(Collectors.toList());

        return new ReportDTO(
                report.getId(),
                focuspoints
        );
    }

    public void addReport(ReportDTO reportDTO) {
        Report report = dtoIntoReport(reportDTO);
        reportRepository.save(report);
    }


    public void chooseFocuspoint(String email, Long focuspointId) {
        Report report = userRepository.findByEmail(email).getLastReport();
        FocuspointDTO focuspointDTO = focuspointService.findById(focuspointId);
        Focuspoint chosenFocuspoint = focuspointService.dtoIntoFocuspoint(focuspointDTO);
        report.setChosenFocuspoint(chosenFocuspoint);

        reportRepository.save(report);
    }

    public ReportDTO findReportById(Long id) {
        Report report = reportRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Report not found with id: " + id));
        return reportIntoDto(report);

    }
}
